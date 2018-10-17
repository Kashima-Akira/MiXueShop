package com.xzy.controller;

import com.xzy.common.FormToken;
//import com.xzy.common.SameUrlData;
import com.xzy.pojo.EasyRegist;
import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.MD5;
import com.xzy.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@FormToken(save = true)
@Controller
@RequestMapping("/regist")
public class RegistController  {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkCode")
    @ResponseBody
    public void checkCode(HttpServletRequest req, HttpServletResponse resp)  {
        Random rand=new Random(System.currentTimeMillis());
        resp.setContentType("image/jpeg");
        int width=130;
        int height=28;
        BufferedImage img=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g=img.getGraphics();
        g.setColor(new Color(230,230,230));
        g.fillRect(0, 0, width, height);
        for(int i=0;i<50;i++)
        {
            g.setColor(new Color(200+rand.nextInt(50),160+rand.nextInt(50),160+rand.nextInt(50)));
            g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<5;i++)
        {
            g.setFont(new Font("微软雅黑",Font.BOLD,20+rand.nextInt(3)));
            g.setColor(new Color(150+rand.nextInt(50),90+rand.nextInt(50),90+rand.nextInt(50)));
            int ra=rand.nextInt(3);
            byte[] x=null;
            if(ra==1){

                x=new byte[]{(byte)(65+rand.nextInt(26))};
            }else if(ra==2){
                x=new byte[]{(byte)(97+rand.nextInt(26))};
            }else{
                x=new byte[]{(byte)(48+rand.nextInt(10))};
            }
            String tem=new String(x, Charset.forName("UTF-8"));
            sb.append(tem);
            g.drawString(tem, i*22+14, 16+rand.nextInt(10));
        }
        req.getSession().setAttribute("checkCode", sb.toString().toLowerCase());
        try {
            ImageIO.write(img, "png",  resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam("name") String name){
        if(userService.checkUsername(name)){
            return "2";
        }
        return "0";
    }
    @RequestMapping("checkEmail")
    @ResponseBody
    public String checkEmail(@RequestParam("email") String email){
        if(userService.checkEmail(email)){
            return "3";
        }
        return "0";
    }
    @RequestMapping("checkTelephone")
    @ResponseBody
    public String checkTelephone(@RequestParam("telephone")String telephone){
        if(userService.checkTelephone(telephone)){
            return "3";
        }
        return "0";
    }
    @RequestMapping("checkImgCode")
    @ResponseBody
    public String checkImgCode(@RequestParam("checkCode") String checkCode, HttpServletRequest request){
        String code=checkCode;
        HttpSession session=request.getSession();
        String coded = (String)session.getAttribute("checkCode");
            if(!code.equals(coded)){
                return "2";
            }
        return "0";
    }
   @FormToken(remove = true)
    @RequestMapping(value = "/doRegist",method = RequestMethod.POST)
    public @ResponseBody EasyRegist regist(@RequestBody User user, HttpServletRequest request,HttpServletResponse response,Model model){
        Map<String,String> err=new HashMap<String ,String>();
       boolean flag=false;
        String username = user.getName();
        String password = user.getPassword();
        String telephone = user.getTelephone();
        String email=user.getEmail();
        String code=user.getCheckCode();
        HttpSession session=request.getSession();
        String coded = (String)session.getAttribute("code");
        if (username == null || username.equals("")) {
            err.put("name",  "用户名不能为空");
            flag=true;
        }
        if(userService.checkUsername(username)){
            err.put("name","用户名已存在");
            flag=true;
        }
        if(!email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
           err.put("email", "邮箱格式不正确");
           flag=true;
       }
        if(userService.checkEmail(email)){
            err.put("email", "邮箱已存在");
            flag=true;
        }
        if (!telephone.matches("^1[3|4|5|7|8][0-9]{9}$")) {
            err.put("telephone", "手机号码不合法");
            flag=true;
        }
        if(userService.checkTelephone(telephone)){
            err.put("telephone", "手机号码已存在");
            flag=true;
        }
        if (password.length() < 6||password.length()>12) {
            err.put("password", "密码长度应为6~12之间");
            flag=true;
        }
        if(code==null||"".equals(code)){
            err.put("code","输入验证码");
            flag=true;
        }
        if(!coded.equals(code)){
            err.put("code","验证码错误");
            flag=true;
        }
        EasyRegist easyRegist=new EasyRegist();
        easyRegist.setName(username);
        easyRegist.setEmail(email);
        easyRegist.setTelephone(telephone);
        easyRegist.setPassword(password);
        easyRegist.setCode(code);
        easyRegist.setErr(err);
       if(flag){
           easyRegist.setFlag(false);
           return easyRegist;
       }else {
           easyRegist.setFlag(true);
           user.setId(UUIDUtil.getUUID());
           user.setName(username);
           user.setEmail(email);
           user.setTelephone(telephone);
           user.setPassword(MD5.tomd5(password));
           Cookie cookie=new Cookie("userId",user.getId());
           cookie.setMaxAge(60*60*24*30);
           response.addCookie(cookie);
           session.setAttribute("user",user);
           session.setMaxInactiveInterval(60*60*24);
           userService.regist(user);
           return easyRegist;
       }
    }
  }
