<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2016/3/11
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>
<html>
<head>
    <title>主页</title>
</head>
<body>
<c:if test="${not empty userid}">
    <input type="button" value="注销" class="warning" align="right"
           onclick="location.href='${pageContext.request.contextPath}/user/logOff'"/>
</c:if>
<hr/>
<form action="${pageContext.request.contextPath}/log/getLogs" method="post">
    <input type="submit" value="查看日志"/>
</form>
<form action="${pageContext.request.contextPath}/user/goChangePassword" method="post">
    <input type="submit" value="修改密码"/>
</form>
<form action="${pageContext.request.contextPath}/user/goUpdUser" method="post">
    <input type="submit" value="修改当前登陆用户信息"/>
</form>
<form action="${pageContext.request.contextPath}/user/getUsers" method="post">
    <input type="submit" value="查看用户列表"/>
</form>
</body>
</html>
