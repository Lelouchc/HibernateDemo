<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2016/3/14
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp" %>
<html>
<head>
    <title>日志记录</title>
</head>
<body>
<input type="button" value="返回主页" class="warning" align="right"
       onclick="location.href='${pageContext.request.contextPath}/user/goHome'"/>
<hr/>
<c:forEach items="${logList}" var="log">
    <p>${log}</p>
</c:forEach>
</body>
</html>
