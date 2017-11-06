<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/5/15
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter 计数器 application 对象 Test</title>
</head>
<body>
<%
  int count = 0;
  if(application.getAttribute("count") == null){
    count ++;
    application.setAttribute("count",count);
  }else {
    count = Integer.parseInt(application.getAttribute("count").toString());
    count ++;
    application.setAttribute("count",count);

  }
  out.print("你是系统的第"+count+"个访问者");

%>
</body>
</html>
