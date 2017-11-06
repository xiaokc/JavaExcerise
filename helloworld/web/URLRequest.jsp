<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request by URL</title>
  <%
    String param = request.getParameter("param");
  %>
</head>

<body>
<a href="URLRequest.jsp?param=Hello">Click me</a><br>
The param you submit is :<%=param%>

</body>
</html>
