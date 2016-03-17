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
<p><input type="button" value="查看日志" onclick="location.href='${pageContext.request.contextPath}/log/getLogs'"/></p>
<p><input type="button" value="修改密码" onclick="location.href='${pageContext.request.contextPath}/user/goChangePassword'"/></p>
<p><input type="button" value="修改当前登陆用户信息" onclick="location.href='${pageContext.request.contextPath}/user/goUpdUser'"/></p>
<p><input type="button" value="查看用户列表" onclick="location.href='${pageContext.request.contextPath}/user/getUsers'"/></p>
</body>
</html>
