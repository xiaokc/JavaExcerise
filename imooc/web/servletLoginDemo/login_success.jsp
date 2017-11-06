<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/9/15
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login_success</title>
</head>
<body>

<div id="container">
  <div class="logo">
    <a href="http://www.iqiyi.com/a_19rrhc1zfx.html?vfm=2008_aldbd"><img src="/assets/logo.png"></a>
  </div>
  <div id="box">
    <%
      String loginUser = "";
      if (session.getAttribute("username") != null){
        loginUser = session.getAttribute("username").toString();
      }
    %>
   欢迎<span style="color: red" ><%=loginUser%></span>，登陆成功！
  </div>
</div>

</body>
</html>
