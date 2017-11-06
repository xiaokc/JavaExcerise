<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/19/15
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP+javabean实现用户登录</title>
</head>
<body>
<div id="container">
    <div class="logo">
        <a href="http://www.iqiyi.com/a_19rrhc1zfx.html?vfm=2008_aldbd"><img src="/assets/logo.png"></a>
    </div>
    <div id="box">
        <form action="dologin.jsp" method="post">
            <p class="main">
                <label>用户名：</label>
                <input type="text" name="username" value="">
            </p>

            <p>
                <label>密码：</label>
                <input type="password" name="password" value="">
            </p>

            <p class="space">
                <input type="submit" name="submit" value="提交" style="cursor: pointer">
            </p>
        </form>
    </div>
</div>
</body>
</html>
