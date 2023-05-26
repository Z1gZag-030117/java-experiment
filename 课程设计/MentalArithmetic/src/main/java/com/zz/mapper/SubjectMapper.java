package com.zz.mapper;

import com.zz.pojo.Subject;
import com.zz.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface SubjectMapper {

    @Insert("insert into subject (id,userAccount,num1,operator1,num2,operator2,num3,answer,num) " +
            "values(0,#{userAccount},#{num1},#{operator1},#{num2},#{operator2},#{num3},#{answer},#{num}) ")
    void add(Subject subject);

    @Delete("delete from subject where id=#{id}")
    void delete(int id);

    @Update("update subject set num=num+1 where id =#{id}")
    void addNum(int id);

    @Update("update subject set num=num-1 where id =#{id}")
    void reduceNum(int id);

    @Select("select * from subject where " +
            "userAccount=#{userAccount} and num1=#{num1} and operator1=#{operator1} " +
            "and num2=#{num2} and operator2=#{operator2} and num3=#{num3} and answer=#{answer}")
    Subject ifExit(Subject subject);

    @Select("select * from subject where userAccount=#{account}")
    List<Subject> selectByAccount(User user);

}
