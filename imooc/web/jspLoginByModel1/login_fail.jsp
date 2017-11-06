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
    <title>login_fail</title>
    <%
      String username="";
      if (session.getAttribute("loginUsers") != null){
        username = session.getAttribute("loginUsers").toString();
      }
    %>
</head>
<body>
<div id="container">
  <div class="logo">
    <a href="http://www.iqiyi.com/a_19rrhc1zfx.html?vfm=2008_aldbd"><img src="/assets/logo.png"></a>
  </div>
  <div id="box">
    <p>
      抱歉<%=username%>，登录失败
    </p>
    <p>
      <a href="login.jsp">返回登陆</a>
    </p>

  </div>
</div>

</body>
</html>
