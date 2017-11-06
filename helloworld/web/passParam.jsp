<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pass param to getParam.jsp</title>
</head>
<body>
Pass param to getParam.jsp from this page<br>
<jsp:forward page="getParam.jsp">
    <jsp:param name="param" value="paramTest"></jsp:param>
</jsp:forward>
</body>
</html>
