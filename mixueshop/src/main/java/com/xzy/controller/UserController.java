package com.xzy.controller;

import com.xzy.pojo.User;
import com.xzy.service.UserService;
import com.xzy.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
   // @Value("${47.95.249.186:8080}")
   // private String FASTDFS_IMAGE_URL;

    @RequestMapping("showUserInfo")
    @ResponseBody
    public  Map show(HttpSession session){
        FinalPay finalPay=new FinalPay();
        User user=(User) session.getAttribute("user");
        Map map=new HashMap();
        Integer level=0;
        if(user!=null)
        {
            String name=user.getName();
            level=user.getLevel();
            if(level==null)
                level=0;
            double discount=finalPay.getDiscount(level)*10;
            String image=user.getImage();
            if(image==null)
                map.put("flag",false);
            else
                map.put("flag",true);
            String email=user.getEmail();
           map.put("name",name);
           map.put("level",level);
           map.put("discount",discount);
           map.put("image",image);
           map.put("email",email);
        }
        return map;
    }
    @RequestMapping("showUserLevel")
    @ResponseBody
    public Integer show1(HttpSession session){
        User user=(User) session.getAttribute("user");
        Integer level=0;
        if(user!=null)
        {
            level=user.getLevel();
            if(level==null)
                level=0;
        }
        return level;
    }

    @RequestMapping("uploadUserImage")
    @ResponseBody
    public String uploadImage(@RequestBody String str,HttpSession session) {
        Base64ToMul base64ToMul=new Base64ToMul();
        MultipartFile uploadFile=base64ToMul.base64ToMultipart(str);
        String url = null;
        //上传图片
        if (uploadFile != null) {
            FastDFSClient fastDFSClient = null;
            try {
                fastDFSClient = new FastDFSClient("classpath:client.conf");

                    String originalFilename = uploadFile.getOriginalFilename();
                    String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

                    String name = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);

                    url="http://47.95.249.186:8080/" + name;
                User user=(User) session.getAttribute("user");
                if(user!=null){
                    user.setImage(url);
                    userService.updateUserInfo(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return url;
    }
    @RequestMapping("updateUserName")
    @ResponseBody
    public Map<String, Object> updateUserName(@RequestParam("name") String username, HttpSession session){
        Map<String,Object> err=new HashMap<String ,Object>();
        User user=(User) session.getAttribute("user");
        boolean flag=true;
        if (username == null || username.equals("")) {
            err.put("name",  "用户名不能为空");
            flag=false;
        }else {
            if(!user.getName().equals(username)){
                if(userService.checkUsername(username)){
                    err.put("name","用户名已存在");
                    flag=false;
                }
            }
            flag=false;
        }
        if(flag){
            user.setName(username);
            userService.updateUserInfo(user);
        }
        err.put("flag",flag);
        return err;
    }
       /* @RequestMapping("updateUserInfo")
        @ResponseBody
        public EasyRegist updateUser(User user, HttpSession session,Model model){
            Map<String,String> err=new HashMap<String,String>();
            boolean flag=false;
            String username = user.getName();
            String telephone = user.getTelephone();
            String email=user.getEmail();
            if (username == null || username.equals("")) {
                err.put("name", "用户名不能为空");
                flag = true;
            }
        if(!email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            err.put("email", "邮箱格式不正确");
            flag=true;
        }
        if (!telephone.matches("^1[3|4|5|7|8][0-9]{9}$")) {
            err.put("telephone", "手机号码不合法");
            flag=true;
        }

        EasyRegist easyRegist=new EasyRegist();
        easyRegist.setName(username);
        easyRegist.setEmail(email);
        easyRegist.setTelephone(telephone);
        easyRegist.setErr(err);
        if(flag){
            easyRegist.setFlag(false);
            return easyRegist;
        }else {
            easyRegist.setFlag(true);
            session.setAttribute("user",user);
            userService.updateUserInfo(user);
            return easyRegist;
        }
    }*/

   @RequestMapping("checkEmail")
    @ResponseBody
    public String checkEmail(@RequestParam("email") String email){
        if(!email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
            return "1";//邮箱格式不正确
        }
        if(!userService.checkEmail(email)){
            return "2"; //找不到此邮箱
        }
        return "0";
    }
   /* @RequestMapping("emailCheckCode")
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
    }*/
    @RequestMapping("updatePwdByEmail")
    @ResponseBody
    public String update( @RequestParam("code")String code, HttpSession session){
        User user=(User)session.getAttribute("user");
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
    @RequestMapping("updatePwd")
    @ResponseBody
    public String update2(@RequestParam("password")String password,HttpSession session){
        User user=(User)session.getAttribute("user");

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


    @RequestMapping("saveUserNamePwd")
    public void save(User user,HttpServletResponse response){
        String name=user.getName();
        String pwd=user.getPassword();
        Cookie username=new Cookie("username",name);
        Cookie password=new Cookie("password",pwd);
        username.setMaxAge(60*60*24*30);
        password.setMaxAge(60*60*24*30);
        response.addCookie(username);
        response.addCookie(password);
    }

}
