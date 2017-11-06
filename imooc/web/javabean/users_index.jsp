<%@ page import="com.po.Users" %>
<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/9/15
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用普通方式创建JavaBean的实例</title>
</head>
<body>
<%
  Users users = new Users();
  users.setUsername("admin");
  users.setPassword("123456");
%>
<h1>
  使用普通方式创建JavaBean的实例
</h1>
<hr>
用户名：<%=users.getUsername()%><br>
密码：<%=users.getPassword()%><br>

</body>
</html>
