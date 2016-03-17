<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2016/3/14
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/user/updPassword" method="post" modelAttribute="userUpdPassword">
    <fieldset class="log">
        <legend>修改密码[${userid}]</legend>
        <p align="center">
            <label for="oldPwd">原密码</label><input type="password" id="oldPwd" name="oldPwd"/>
            <form:errors path="oldPwd" cssClass="warning"/>
        </p>
        <p align="center">
            <label for="newPwd">新密码</label><input type="password" id="newPwd" name="newPwd"/>
            <form:errors path="newPwd" cssClass="warning"/>
        </p>
        <p align="center">
            <label for="newPwdRepeat">确认新密码</label><input type="password" id="newPwdRepeat" name="newPwdRepeat"/>
            <form:errors path="newPwdRepeat" cssClass="warning"/>
        </p>
        <p align="center" style="color: red;font-size: small;">${pwdResult}</p>
        <p align="center">
            <input type="button" value="取消" onclick="location.href='${pageContext.request.contextPath}/user/goHome'"/>
            <input type="submit" value="确认"/>
        </p>
    </fieldset>
</form:form>
</body>
</html>
