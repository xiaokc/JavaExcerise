<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/4/15
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include_1 just a test</title>
</head>
<body>
<jsp:include page="header.txt" flush="true"></jsp:include>
这是一个 JSP 动作标签 include 的使用示例程序。<br>
<jsp:include page="first.jsp" flush="true"></jsp:include>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
