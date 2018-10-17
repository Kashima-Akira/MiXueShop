//package com.xzy.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.xzy.jedis.JedisClient;
//import com.xzy.jedis.JedisClientCluster;
//import com.xzy.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by css on 2018/8/9.
// */
//@Component
//public class SessionUtils {
//    @Autowired
//    private static JedisClient jedis;
//
//    public JedisClient getJedis() {
//        return jedis;
//    }
//
//    public void setJedis(JedisClient jedis) {
//        this.jedis = jedis;
//    }
//
//    @PostConstruct
//    public void init(){
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//        System.out.println("init");
//    }
//    public static User getAttrivute(HttpServletRequest request){
//        User user=null;
//
//        Cookie[] cookies = request.getCookies();
//        System.out.println("\n\n\n\n\n");
//        for(Cookie ck:cookies){
//            System.out.println(ck.getName()+":"+ck.getValue());
//        }
//        System.out.println("\n\n\n\n\n");
//
//
//        for (Cookie cookie : cookies){
//            if("userId".equals(cookie.getName())){
//                String value = cookie.getValue();
//                if(!jedis.exists(value)){
//                    continue;
//                }
//                String userId = jedis.get(value);
//                if(userId==null||"".equals(userId.trim())){
//                    continue;
//                }
//                jedis.expire("userId",60*60*24*30);
//                user = JSON.parseObject(userId, User.class);
//                break;
//            }
//        }
//        return user;
//    }
//    public static User setAttrivute(User user){
//        if(user!=null){
//            jedis.set(user.getId(),JSON.toJSONString(user));
//            jedis.expire(user.getId(),60*60*24*30);
//        }
//        return user;
//    }
//    public  static Long removeAttrivute(String userId){
//        return jedis.del(userId);
//    }
//}
