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
    <title>使用uesBean动作创建JavaBean的实例</title>
</head>
<body>
<jsp:useBean id="myUsers" class="com.po.Users" scope="page"/>
<h1>
  使用uesBean动作创建JavaBean的实例
</h1>
<hr>
用户名：<%=myUsers.getUsername()%><br>
密码：<%=myUsers.getPassword()%><br>

</body>
</html>
