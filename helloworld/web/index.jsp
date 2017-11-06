<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 6/29/15
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello world</title>

</head>
<body>
<div>
    <ul>java</ul>
    <ul>idea</ul>
</div>
<%--jsp注释客户端不可见--%>
<!--html注释客户端可见-->
<div>

    <%
        //单行注释
        /*多行注释*/
       // System.out.println("java代码");
        out.print("java code");
    %>

</div>
</body>
</html>
