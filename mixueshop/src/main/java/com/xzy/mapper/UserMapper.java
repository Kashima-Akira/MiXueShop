package com.xzy.mapper;

import com.xzy.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    //根据用户id查询用户所有信息
    User findUserById(String id);
    //添加用户
    void addUser(User user);
    //删除用户
    void deleteUserById(String id);
    //修改用户
    void updateById(User user);
    void updatePwd(User user);
    //根据手机号查询用户
    User findUserByTelephone(String telephone);
    //根据邮箱查询用户
    User findUserByEmail(String eamil);
    //根据用户名查询用户
    User findByUsername(String name);
    User findByNameAndPwd(@Param("name") String name, @Param("password") String password);

}
