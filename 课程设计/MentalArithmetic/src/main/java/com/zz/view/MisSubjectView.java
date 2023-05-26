package com.zz.view;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.SubjectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import java.util.Scanner;

/**
 * @author �솴
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
        System.out.println("��������Ĵ����Լ��������");
        List<Subject> subjects = subjectService.selectMisByAccount(user);
        for (int i = 0; i < subjects.size(); i++) {
            Subject subject = subjects.get(i);
            System.out.println(subject.showMis() + "  ���������" + subject.getNum() );
        }
        System.out.println("1.��������   2.����");
        int choice = scanner.nextInt();
        int misNum=0;
        if (choice == 1) {
            for (int i = 0; i < subjects.size(); i++) {
                Subject subject = subjects.get(i);
                System.out.print(subject.show());
                int answer = scanner.nextInt();
                if (answer!=subject.getAnswer()){ //����������Ȼ����
                    misNum++;
                    subject.num++;
                    subject.misAnswer=answer;
                    subjectService.addNum(subject);  //����������++
                }else {  //����������ȷ
                    subject.num=0;
                    subjectService.delete(subject);  //����������ݿ���ɾ��
                }
            }
            misSubject(misNum,subjects);
            new UserView(user);
        } else {
            new UserView(user);  //����
        }
    }

    private static void misSubject( int misNum, List<Subject> subjects) {
        System.out.println("---------------");
        System.out.println("һ������" + misNum + "��,�ֱ��ǣ�");
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).num != 0) {
                System.out.println(subjects.get(i).showMis()+"="+subjects.get(i).misAnswer+" -->("+subjects.get(i).getAnswer()+")");
            }
        }
    }

}
