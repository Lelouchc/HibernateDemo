<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2016/3/9
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<p>status:<%=request.getAttribute("javax.servlet.error.status_code") %></p>
<p>reason:<%=request.getAttribute("javax.servlet.error.message") %></p>
<p>exception_type:<%=request.getAttribute("javax.servlet.error.exception_type") %></p>
<p>exception:<%=request.getAttribute("javax.servlet.error.exception") %></p>
<p>request_uri:<%=request.getAttribute("javax.servlet.error.request_uri") %></p>
<p>servlet_name:<%=request.getAttribute("javax.servlet.error.servlet_name") %></p>
</body>
</html>
