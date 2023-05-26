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
 * @author 朱喆
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl extends JPanel implements UserService {

    //1.获取sqlSession
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = factory.openSession();
    //2.获取UserMapper
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
            JOptionPane.showMessageDialog(null, "输入不能为空！", "输入不能为空！", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!psd.equals(cpsd)){
            JOptionPane.showMessageDialog(null,"两次输入密码不同！","两次输入密码不同！",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        //判断这个要注册的用户名是否存在
        User u = mapper.selectByUserAccount(user.getAccount());
        if (u == null) { // u为空表示此用户不存在，可以注册
            mapper.add(user);
            sqlSession.commit();
        }else {
            JOptionPane.showMessageDialog(null,"用户已经存在！","用户已经存在！",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        sqlSession.close();
        return true;
    }


}
