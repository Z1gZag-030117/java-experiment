package com.zz.service.impl;

import com.zz.mapper.UserMapper;
import com.zz.pojo.User;
import com.zz.service.UserService;
import com.zz.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * @author �솴
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl extends JPanel implements UserService {

    //1.��ȡsqlSession
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = factory.openSession();
    //2.��ȡUserMapper
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public User login(String account, String password) {
        User user = mapper.select(account, password);
        sqlSession.close();
        return user;
    }

    @Override
    public boolean register(String account, String name, String psd, String cpsd, String mailBoxNum,String grander) {
        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(psd);
        user.setMailbox(mailBoxNum);
        user.setGander(grander);
        if (account.equals("")||name.equals("")||psd.equals("")||mailBoxNum.equals("")){
            JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�", "���벻��Ϊ�գ�", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!psd.equals(cpsd)){
            JOptionPane.showMessageDialog(null,"�����������벻ͬ��","�����������벻ͬ��",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //�ж����Ҫע����û����Ƿ����
        User u = mapper.selectByUserAccount(user.getAccount());
        if (u == null) { // uΪ�ձ�ʾ���û������ڣ�����ע��
            mapper.add(user);
            sqlSession.commit();
        }else {
            JOptionPane.showMessageDialog(null,"�û��Ѿ����ڣ�","�û��Ѿ����ڣ�",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        sqlSession.close();
        return true;
    }


}
