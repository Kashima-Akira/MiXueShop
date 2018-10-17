package com.xzy.common;

import com.xzy.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonInterceptor implements HandlerInterceptor {
    //拦截前处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
      /*  User user = (User) request.getSession().getAttribute("user");
        if(user!=null) {
            return true;
        }
        return false;*/
        User user = (User) request.getSession().getAttribute("user");

        String url = request.getRequestURI();

        if (StringUtils.isNotBlank(url) && url.toLowerCase().indexOf("login") < 0 && url.toLowerCase().indexOf("regist") < 0) {
            if (null == user) {
                //String localUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
                // response.sendRedirect(localUrl + "login");
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
    //拦截后处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception { }
    //全部完成后处理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) throws Exception { }
}
