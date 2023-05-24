package com.zz.service;


import com.zz.pojo.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserService  {
    User login(String username,String password);
    boolean register(String account,String name ,String psd,String cpsd,String mailBoxNum,String grander);
}
