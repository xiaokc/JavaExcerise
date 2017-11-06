<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/17/15
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setProperty动作元素</title>
</head>
<body>
<h1>setProperty动作元素</h1>
<jsp:useBean id="myUsers" class="com.po.Users" scope="page"/>

<%--根据表单自动匹配User.java中所有与表单中名字相同的属性--%>
<%--<jsp:setProperty name="myUsers" property="*"/>--%>

<%--根据表单匹配部分属性--%>
<%--<jsp:setProperty name="myUsers" property="username"/>--%>

<%--跟表单无关，通过手工设置属性--%>
<%--<jsp:setProperty name="myUsers" property="username" value="xiaokecong"/>
<jsp:setProperty name="myUsers" property="password" value="44444"/>--%>

<%--通过url传递参数给属性赋值--%>
<%--<jsp:setProperty name="myUsers" property="username"/>
<jsp:setProperty name="myUsers" property="password" param="mypassword"/>--%>


<%--使用传统表达式方式获取用户名和密码--%>
<%--用户名：<%=myUsers.getUsername()%>--%>
<%--密码：<%=myUsers.getPassword()%>--%>

<jsp:setProperty name="myUsers" property="username"/>
<jsp:setProperty name="myUsers" property="password"/>
<%--使用getProperty动作元素获取用户名和密码--%>
用户名：<jsp:getProperty name="myUsers" property="username"/><br>
密码：<jsp:getProperty name="myUsers" property="password"/>

</body>
</html>
