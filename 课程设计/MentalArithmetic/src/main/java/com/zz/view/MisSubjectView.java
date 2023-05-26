package com.zz.view;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.SubjectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

/**
 * @author 朱喆
 * @version 1.0
 */
public class MisSubjectView {

    public MisSubjectView(User user) {
        init(user);
    }

    private void init(User user) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SubjectService subjectService = (SubjectService) context.getBean("subject");
        Scanner scanner = new Scanner(System.in);
        System.out.println("以下是你的错题以及错误次数");
        List<Subject> subjects = subjectService.selectMisByAccount(user);
        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println(subject.showMis() + "  错误次数：" + subject.getNum() );
        }
        System.out.println("1.重做错题   2.返回");
        int choice = scanner.nextInt();
        int misNum=0;
        if (choice == 1) {
            for (int i = 0; i < subjects.size(); i++) {
                Subject subject = subjects.get(i);
                System.out.print(subject.show());
                int answer = scanner.nextInt();
                if (answer!=subject.getAnswer()){ //重做错题仍然错误
                    misNum++;
                    subject.num++;
                    subject.misAnswer=answer;
                    subjectService.addNum(subject);  //错题错误次数++
                }else {  //错题重做正确
                    subject.num=0;
                    subjectService.delete(subject);  //将错题从数据库中删除
                }
            }
            misSubject(misNum,subjects);
            new UserView(user);
        } else {
            new UserView(user);  //返回
        }
    }

    private static void misSubject( int misNum, List<Subject> subjects) {
        System.out.println("---------------");
        System.out.println("一共错了" + misNum + "题,分别是：");
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).num != 0) {
                System.out.println(subjects.get(i).showMis()+"="+subjects.get(i).misAnswer+" -->("+subjects.get(i).getAnswer()+")");
            }
        }
    }

}
