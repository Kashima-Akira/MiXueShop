package com.xzy.service;

import com.xzy.pojo.User;

public interface UserService {
    User findUserById(String id);
    //修改密码
    User findUserByEmail(String eamil);
    //删除用户
    void deleteUserById(String id);
    //更改用户信息
    void updateUserInfo(User user);
    void updatePwd(User user);
    //用户注册
    void regist(User user);
    //用户登录
    User findUserByUserName(String name);
    User findUserByTelephone(String telephone);
    User login(String name, String password);
    boolean checkUsername(String name);
    boolean checkEmail(String email);
    boolean checkTelephone(String telephone);


}
