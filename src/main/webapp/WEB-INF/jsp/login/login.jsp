<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2016/3/8
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<div>
    <form:form action="${pageContext.request.contextPath}/user/login" method="post" modelAttribute="userLogin">
        <fieldset class="log">
            <legend>登陆</legend>
            <p align="center">
                <label for="account">账号</label>
                <form:input path="account" autocomplete="off" maxlength="20" placeholder="账号/手机号/邮箱"/>
                <form:errors path="account" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="password">密码</label>
                <form:password path="password" maxlength="20"/>
                <form:errors path="password" cssClass="warning"/>
            </p>
            <p align="center" style="color: red;font-size: small;">${logResult}</p>
            <p align="center">
                <input type="button" value="注册"
                       onclick="location.href='${pageContext.request.contextPath}/user/goRegister'"/>
                <input type="submit" value="登陆"/>
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
