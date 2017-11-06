<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check the status of Login</title>
</head>
<%
  String name = request.getParameter("username");
  String psw = request.getParameter("password");
  if(name.length()>0 && psw.length()>0){
    session.setAttribute("status","Login");
    response.sendRedirect("LoginMain.jsp");
  }else {
    response.sendRedirect("Login.jsp");
  }
%>
<body>

</body>
</html>
