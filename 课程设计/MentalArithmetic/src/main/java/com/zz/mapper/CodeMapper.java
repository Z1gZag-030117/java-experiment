package com.zz.mapper;

import com.zz.pojo.Code;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface CodeMapper {

    @Select("select code from codetable where eamil=#{email}")
    String select(String email);

    @Insert("insert into codetable values(#{email},#{codeNum})")
    Code add(Code code);

}
