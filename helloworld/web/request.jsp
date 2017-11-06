<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request just a Test</title>
</head>
<body>
<%
  request.setAttribute("attr", "attrValue");
  out.print(request.getAttribute("attr"));
  out.print(request.getContextPath());
  out.print(request.getCookies());
  out.print(request.getHeader("Host"));
  out.print(request.getServerPort());
  out.print(request.getRemoteAddr());

  request.removeAttribute("attr");
  out.print(request.getAttribute("attr"));

%>
</body>
</html>
