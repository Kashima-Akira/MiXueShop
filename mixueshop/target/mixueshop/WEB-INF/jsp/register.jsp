<%--
  Created by IntelliJ IDEA.
  User: 18505
  Date: 2018/8/5
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function clearUsernameError() {
            var usernameError = document.getElementById("usernameError");
            usernameError.innerHTML = "";
        }
        function clearEmailError() {
            var emailError = document.getElementById("emailError");
            emailError.innerHTML = "";
        } {
            var passwordError = document.getElementById("passwordError");
            passwordError.innerHTML = "";
        }
        function clearPasswordError() {
            var passwordError = document.getElementById("passwordError");
            passwordError.innerHTML = "";
        }
        function clearTelephoneError() {
            var telephoneError = document.getElementById("telephoneError");
            telephoneError.innerHTML = "";
        }
        function clearCheckCodeError() {
            var checkCodeError = document.getElementById("checkCodeError");
            checkCodeError.innerHTML = "";
        }
    </script>
</head>
<body>

<form action="/regist/register.action">
    <table border="0" cellpadding="5">
        <tr align="center">
            <td colspan="2"><h3>用户注册</h3></td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" name="name" onfocus="clearUsernameError()"/>
            </td>
            <td>
                <span id="usernameError"><form:errors path="name" cssClass="error" cssStyle="color:red"/></span>
            </td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td>
                <input type="text" name="email" onfocus="clearEmailError()"/>
            </td>
            <td>
                <span id="emailError"><form:errors path="email" cssClass="error" cssStyle="color:red"/></span>
            </td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="telephone" onfocus="clearTelephoneError()"/></td>
            <td>
                <span id="telephoneError"><form:errors path="telephone" cssClass="error" cssStyle="color:red"/></span>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input  name="password" type="password" onfocus="clearPasswordError()"/>
            </td>
            <td>
                <span id="passwordError"><form:errors path="password" cssClass="error" cssStyle="color:red"/></span>
            </td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td>
                <input name="checkCode" type="text" onfocus="clearCheckCodeError()"/>
                <img id="rand_img" src="${pageContext.request.contextPath}/regist/checkCode.action" onclick="ran()" style="cursor:pointer;"/>
            </td>
            <script type="text/javascript">
                function ran(){
                    var im=document.getElementById("rand_img");
                    im.src="${pageContext.request.contextPath}/regist/checkCode?m="+Math.random();
                }
            </script>
            <td>
                <span id="checkCodeError"><form:errors path="checkCode" cssClass="error" cssStyle="color:red"/></span>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>

