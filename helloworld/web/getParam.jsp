<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get param from passParam.jsp</title>
</head>
<body>
Get param from passParam.jsp<br>
The param is <%
  out.print(request.getParameter("param"));
%>
</body>
</html>
