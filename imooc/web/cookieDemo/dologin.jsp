<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/20/15
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.net.URLEncoder" %>
<%
  request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <title>dologin</title>
</head>
<body>
<%--<jsp:useBean id="loginUsers" class="com.po.Users" scope="page"></jsp:useBean>
<jsp:useBean id="userDao" class="com.dao.UsersDao" scope="page"></jsp:useBean>
<jsp:setProperty name="loginUsers" property="*"/>--%>

<h1>登陆成功</h1>
<hr>
<br>
<br>
<br>
<br>
<a href="users.jsp" target="_blank">查看用户信息</a>


<%
  request.setCharacterEncoding("utf-8");
  //判断用户是否勾选了十天内记住登录状态
  String[] isUserCookies = request.getParameterValues("isUserCookies");
  if (isUserCookies != null && isUserCookies.length > 0){
    //用户名和密码保存在Cookie对象中
    //使用URLEncoder解决无法在Cookie当中保存中文字符串问题
    String username = URLEncoder.encode(request.getParameter("username"), "utf-8");
    String password = URLEncoder.encode(request.getParameter("password"), "utf-8");

    Cookie usernameCookie = new Cookie("username", username);
    Cookie passwordCookie = new Cookie("password", password);

    //设置最大生存期限为10天
    usernameCookie.setMaxAge(10*24*60*60);
    passwordCookie.setMaxAge(10*24*60*60);

    response.addCookie(usernameCookie);
    response.addCookie(passwordCookie);


  }
  else{
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0){
      for(Cookie c:cookies){
        if (c.getName().equals("username") || c.getName().equals("password")){
          c.setMaxAge(0);//设置Cookie对象失效
          response.addCookie(c);//重新保存
        }
      }
    }
  }

  //


%>
</body>
</html>
