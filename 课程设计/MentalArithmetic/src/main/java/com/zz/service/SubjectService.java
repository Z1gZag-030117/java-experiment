package com.zz.service;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.impl.SubjectServiceImpl;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface SubjectService {

    void save(Subject subject,User user);   //第一次错，将题目存入数据库
    void delete(Subject subject); //重做错题时做对，删除题目
    void addNum(Subject subject); //有一次做错，修改num++
    void reduceNum(Subject subject,User user); //作对,较少num——
    List<Subject> selectMisByAccount(User user);
}
