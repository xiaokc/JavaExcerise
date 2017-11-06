<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>After Login</title>
</head>
<body>
<%
  Object status = session.getAttribute("status");
  if(status != null){
    out.print("You have logined in successful!");
  }else{
    response.sendRedirect("Login.jsp");
  }

%>
</body>
</html>
