package com.zz.service.impl;

import com.zz.mapper.SubjectMapper;
import com.zz.mapper.UserMapper;
import com.zz.pojo.Subject;
import com.zz.pojo.User;
import com.zz.service.SubjectService;
import com.zz.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service("subject")
public class SubjectServiceImpl implements SubjectService {


    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = factory.openSession();
    SubjectMapper mapper = sqlSession.getMapper(SubjectMapper.class);


    @Override
    public void save(Subject subject, User user) {
        Subject s = mapper.ifExit(subject);
        if (s == null) { //表中不存在这题,将这题存入表中
            mapper.add(subject);
        } else {
            mapper.addNum(s.getId());
        }
        sqlSession.commit();
    }

    @Override
    public void delete(Subject subject) {
        mapper.delete(subject.getId());
        sqlSession.commit();
    }

    @Override
    public void addNum(Subject subject) {
        mapper.addNum(subject.getId());
        sqlSession.commit();
    }

    @Override
    public void reduceNum(Subject subject, User user) {
        mapper.reduceNum(subject.getId());
    }

    @Override
    public List<Subject> selectMisByAccount(User user) {
        List<Subject> subjects = mapper.selectByAccount(user);
        return subjects;
    }


}
