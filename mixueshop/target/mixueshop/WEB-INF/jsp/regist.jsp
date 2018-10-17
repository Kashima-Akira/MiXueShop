<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 18505
  Date: 2018/7/27
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/regist/doRegist.action"  method="post">
        <div class="in">
            <br>
            <span class="left">用户名：</span>
            <input type="text" required="required" placeholder="请输入用户名" name="name" id="username"/>
            <span id="usernameMsg" class="warning">${usernameMsg }</span>
        </div>
        <div class="in">
            <span class="left">邮箱：</span>
            <input type="email" required="required" placeholder="请输入邮箱地址" name="email" id="mail"/>
            <span id="emailMsg" class="warning">${emailMsg }</span>
        </div>
        <div class="in">
            <span class="left">手机号：</span>
            <input type="text" required="required" placeholder="请输入手机号" name="telephone"/>
            <span id="telMsg" class="warning">${telMsg }</span>
        </div>
        <div class="in">
            <span class="left">密码：</span>
            <input type="password" required="required" placeholder="请输入密码" name="password"/>
            <span id="passwordMsg" class="warning">${passwordMsg}</span>
        </div>
        <div class="in">
            <span class="left">验证码：</span>
            <input type="text" required="required"  name="code"/>
        </div>
            <img id="rand_img" src="${pageContext.request.contextPath}/regist/checkCode" onclick="ran()"/>
            <span class="warning">${idcodeMsg }</span>
            <script type="text/javascript">
                function ran(){
                    var im=document.getElementById("rand_img");
                    im.src="${pageContext.request.contextPath}/regist/checkCode?m="+Math.random();
                }
            </script>
       <br>
        <hr>
        <div class="bottom">
            <input type="submit" value="注册">
            <input type="reset" value="重置">
        </div>
    </form>

</body>
</html>