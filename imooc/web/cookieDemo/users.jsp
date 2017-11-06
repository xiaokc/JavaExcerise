<%@page  contentType="text/html;charset=UTF-8" language="java" import="java.net.URLDecoder" %>
<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/20/15
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users用户信息</title>
</head>
<body>
<h1>用户信息</h1>
<hr>
<%
  String username = "";
  String password = "";
  Cookie[] cookies = request.getCookies();
  if (cookies != null && cookies.length > 0){
    for(Cookie c:cookies){
      if (c.getName().equals("username")){
        //Cookie中的字符解码
        username = URLDecoder.decode(c.getValue(),"utf-8");

      }else if (c.getName().equals("password")){
        password = URLDecoder.decode(c.getValue(),"utf-8");
      }
    }
  }
%>
<br>
<br>
<br>
<br>
用户名：<%=username%><br>
密码：<%=password%><br>
</body>
</html>
