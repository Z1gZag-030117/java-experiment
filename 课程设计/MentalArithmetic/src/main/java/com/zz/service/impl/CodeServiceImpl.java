package com.zz.service.impl;

import com.zz.mapper.CodeMapper;
import com.zz.pojo.Code;
import com.zz.service.CodeService;
import com.zz.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

/**
 * @author 朱喆
 * @version 1.0
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    SqlSession sqlSession = factory.openSession();
    CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);

    @Override
    public Code saveCode(Code code) {
        return mapper.add(code);
    }

    @Override
    public String selectCode(String email) {
        return mapper.select(email);
    }
}
