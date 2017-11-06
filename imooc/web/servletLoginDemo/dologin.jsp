<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/19/15
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("utf-8");
%>
<%--使用jsp+javabean实现用户登录--%>

<jsp:useBean id="loginUsers" class="com.po.Users" scope="page"/>
<jsp:useBean id="usersDao" class="com.dao.UsersDao" scope="page"/>

<jsp:setProperty name="loginUsers" property="*"/>
<%
  if (usersDao.usersLogin(loginUsers)){//登录成功，服务器内部转发到页面login_success.jsp
    session.setAttribute("loginUsers",loginUsers.getUsername());
    request.getRequestDispatcher("login_success.jsp").forward(request,response);
  }else {
    //否则重定向到login_fail.jsp
    response.sendRedirect("login_fail.jsp");
  }
%>