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
    <title>注册</title>
</head>
<body>
<div align="center">
    <form:form action="${pageContext.request.contextPath}/user/register" method="post" modelAttribute="user">
        <fieldset class="log">
            <legend>注册</legend>
            <p align="center">
                <label for="account">账号</label>
                <form:input path="account" autocomplete="off" maxlength="20"/>*
                <form:errors path="account" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="password">密码</label>
                <form:password path="password" maxlength="20"/>*
                <form:errors path="password" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="username">名称</label>
                <form:input path="username" autocomplete="off" maxlength="30"/>*
                <form:errors path="username" cssClass="warning"/>
            </p>
            <p align="center">
                性别
                <form:radiobutton path="sex" value="male" label="男"/>
                <form:radiobutton path="sex" value="female" label="女"/>
                <form:errors path="sex" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="birthday">生日</label>
                <input type="date" id="birthday" name="birthday" value="${user.birthday}"/>
                <form:errors path="birthday" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="phone">电话</label>
                <form:input path="phone" autocomplete="off" maxlength="20"/>
                <form:errors path="phone" cssClass="warning"/>
            </p>
            <p align="center">
                <label for="email">邮箱</label>
                <form:input path="email" autocomplete="off" maxlength="30"/>
                <form:errors path="email" cssClass="warning"/>
            </p>
            <p align="center" style="color: red;font-size: small;">${regResult}</p>
            <p align="center">
                <input type="submit" value="注册"/>
                <input type="button" value="取消"
                       onclick="location.href='${pageContext.request.contextPath}/user/goLogin'"/>
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
