package com.zz.mapper;

import com.zz.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 朱喆
 * @version 1.0
 */
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户对象
     * @param account
     * @param password
     * @return
     */
    @Select("select * from user where account = #{account} and password = #{password}")
    User select(@Param("account") String account, @Param("password") String password);

    /**
     * 根据用户名查询用户对象
     * @return
     */
    @Select("select * from user where name = #{username}")
    User selectByUsername(String username);

    @Select("select * from user where account=#{account}")
    User selectByUserAccount(String account);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user values(#{account},#{name},#{password},#{gander},#{mailbox})")
    void add(User user);
}
