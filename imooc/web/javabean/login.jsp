<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/17/15
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My jsp 'login.jsp' starting page</title>
</head>
<body>
<h1>系统登录</h1>
<form name="loginform" action="dologin.jsp?myusername=8888&mypassword=99999" method="post">
  <table>
    <tr>
      <td>用户名：</td>
      <td><input type="text" name="username" value=""></td>
    </tr>
    <tr>
      <td>密码：</td>
      <td><input type="password" name="password" value=""></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><input type="submit" name="登录"></td>
    </tr>
  </table>
</form>
</body>
</html>
