package com.xzy.service.serviceImp;

import com.xzy.mapper.UserMapper;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserById(String id)  {
        User user= userMapper.findUserById(id);
        return user;
    }


    @Override
    public void deleteUserById(String id)  {
        userMapper.deleteUserById(id);
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void updatePwd(User user) {
        userMapper.updatePwd(user);
    }

    @Override
    public void regist(User user) {
        userMapper.addUser(user);
    }
    @Override
    public boolean checkUsername(String name) {
        boolean isExist = false;
            User user = userMapper.findByUsername(name);
            if(user != null ){
                isExist = true;
            }
        return isExist;
    }
    @Override
    public boolean checkEmail(String email){
        boolean isExist = false;
        User user = userMapper.findUserByEmail(email);
        if(user != null ){
            isExist = true;
        }
        return isExist;
    }
    @Override
    public boolean checkTelephone(String telephone){
        boolean isExist = false;
        User user = userMapper.findUserByTelephone(telephone);
        if(user != null ){
            isExist = true;
        }
        return isExist;
    }
    @Override
    public User findUserByTelephone(String telephone) {

        return userMapper.findUserByTelephone(telephone);
    }

    @Override
    public User login(String name, String password) {
        return userMapper.findByNameAndPwd(name, password);
    }

    @Override
    public User findUserByEmail(String eamil) {
        return userMapper.findUserByEmail(eamil);
    }

    @Override
    public User findUserByUserName(String name) {
        return userMapper.findByUsername(name);
    }

}
