<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript">
        $("#submit").click(function () {
            var user = $("#name").val();
            var password = $("#password").val();
            if(user=="") {
                alert("用户名不可为空!");
            } else if(password==""){
                alert("密码不可为空!");
            } else {
                $.ajax({
                    async: false,
                    type: "POST",
                    url: '${pageContext.request.contextPath}/login/doLogin',
                    contentType: "application/text; charset=utf-8",
                    data: $("#loginForm").serialize(),
                    success: function (data) {
                        if(data.flag==false) {
                            alert(data.err.get("name"));
                            alert(data.err.get("password"));
                        } else {
                            window.location.href="${pageContext.request.contextPath}/index";
                        }
                    },
                    error: function () {
                        alert("数据获取失败")
                    }
                })
            }
        })
    </script>
</head>
<body>

    <form name="loginForm" action="${pageContext.request.contextPath}/login/doLogin.action" method="post">
        用户名：<input type="text" name="name"/>
        <span style="color: red;font-size: medium;">${easyLogin.err.get("name")}</span><br>
        密码：<input type="password" name="password">
        <span style="color: red;font-size: medium;">${easyLogin.err.get("password")}</span><br>
        <input type="submit" value="登录"  onsubmit="return ${easyLogin.flag}">
    </form>
</body>
</html>