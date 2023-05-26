package com.zz.service;


import com.zz.pojo.User;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserService  {
    User login(String username,String password);
    boolean register(String account,String name ,String psd,String cpsd,String mailBoxNum,String grander);
}
