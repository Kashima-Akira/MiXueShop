package com.xzy.controller;



import com.xzy.common.FormToken;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.EmailUtils;
import com.xzy.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;


@FormToken(save = true)
@Controller
@RequestMapping("/login")
public class LoginController  {
    @Autowired
    private UserService userService;

    @RequestMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam(value = "name",required = false) String name){
        String phone = "^[1][34578]\\d{9}$";
        if(name==null) {
            return "2";
        }else {
            if (name.matches(phone)) {
                if (!userService.checkTelephone(name)) {
                    return "1";
                }
                return "0";
            } else {
                if (!userService.checkUsername(name)) {
                    return "1";
                }
                return "0";
            }
        }
    }
    @FormToken(remove = true)
    @RequestMapping(value = "/doLogin")
    @ResponseBody
    public  Map<String,Object> login(@RequestBody User user, HttpServletResponse response, HttpSession session){
        boolean flag=true;
        Map<String,Object> err=new HashMap<String,Object>();
        String name=user.getName();
        String password=user.getPassword();
        User duser=null;
        String phone = "^[1][34578]\\d{9}$";
        if(name==null||"".equals(name)){
            err.put("name","请输入账号");
            err.put("flag",false);
            return err;
        }
        if(password==null||"".equals(password)){
            err.put("password","请输入密码");
            err.put("flag",false);
            return err;
        }
        if(name.matches(phone)){
           duser= userService.findUserByTelephone(name);
           if(duser==null) {
               err.put("name","手机号不存在");
               err.put("flag",false);
               return err;
           }else{
               if(!duser.getPassword().equals(MD5.tomd5(password))){
                   err.put("password","密码错误");
                   err.put("flag",false);
                   return err;
               }
           }
        }else {
            duser=userService.findUserByUserName(name);
            if(duser==null) {
                err.put("name","用户名不存在");
                err.put("flag",false);
                return err;
            }else{
                if(!duser.getPassword().equals(MD5.tomd5(password))){
                    err.put("password","密码错误");
                    err.put("flag",false);
                    return err;
                }
            }
        }
        err.put("flag",flag);
        Cookie cookie=new Cookie("userId",duser.getId());
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        session.setAttribute("user",duser);
        session.setMaxInactiveInterval(60*60*24);
        err.put("user",duser);
        return err;
    }

    @RequestMapping("/isLogin")
    @ResponseBody
    public boolean isLogin(HttpSession session){
            if(session.getAttribute("user")!=null){
                return true;
            }
            return false;
    }


    @RequestMapping("/emailCheckCode")
    public void checkCode(@RequestParam("email") String email,HttpSession session)  {
        String code= null;
        if (email!=null) {
            try {
                code = EmailUtils.createEmail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.setAttribute("checkcode", code);
            session.setAttribute("email",email);
        }
    }
    @RequestMapping("/forgetPwdByEmail")
    @ResponseBody
    public String update1( @RequestParam("code")String code, HttpSession session){
        String email=(String) session.getAttribute("email");
        User user=userService.findUserByEmail(email);
        String uid=user.getId();
        String coded=(String) session.getAttribute("checkcode");
        if(code==null||"".equals(code)){
            return "1";
        }else {
            if(!code.equals(coded)){
                return  "1";//验证码错误
            }else {
                Map map=new HashMap();
                map.put("uid",uid);
                map.put("code",coded);
                session.setAttribute("repasswd",map);
                return "2";//验证成功
            }
        }
    }
    @RequestMapping("/forgetPwd")
    @ResponseBody
    public String update3(@RequestParam("password")String password,HttpSession session){
        String email=(String) session.getAttribute("email");
        User user=userService.findUserByEmail(email);
        String uid=user.getId();
        if (password.length() < 6||password.length()>12) {
            return "0";//密码长度不合法
        }
        Map repasswd = (HashMap) session.getAttribute("repasswd");
        session.removeAttribute("repasswd");
        if(repasswd==null||!uid.equals(repasswd.get("uid"))){
            return "1";//非法操作
        }else {
            user=userService.findUserById(uid);
            if(user.getPassword().equals(MD5.tomd5(password)))
                return "2";//密码与原密码不能相同
            user.setPassword(MD5.tomd5(password));
            userService.updatePwd(user);
            return "3";//成功
        }
    }
    /**
     * 登录注销
     * @return
     */
    @RequestMapping("/doLogout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "ok";
    }
}
