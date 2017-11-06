<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form request test</title>
</head>
<body>
<form action="FormRequest.jsp" method="post">
username:<input type="text" name="username"><br>
password:<input type="password" name="password"><br>
submit:<input type="submit" name="submit" value="submit">
</form>

<%
  out.print(request.getParameter("username")+"<br>");
  out.print(request.getParameter("password"));
%>
</body>
</html>
