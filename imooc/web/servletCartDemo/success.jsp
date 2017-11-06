<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/30/15
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功添加商品到购物车</title>
</head>
<body>
<center>
  <img src="/images/add_cart_success.jpg">
  <hr>
  <%
    String id = request.getParameter("id");
    String number = request.getParameter("number");

  %>
  您成功添加了<%=number%>件编号为<%=id%>的商品!&nbsp;&nbsp;&nbsp;&nbsp;
  <br>
  <br>
  <br>

</center>
</body>
</html>
