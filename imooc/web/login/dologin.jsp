<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/9/15
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--login.jsp页面的业务逻辑处理--%>
<%
    String username = "";
    String password = "";
    request.setCharacterEncoding("utf-8");//防止中文乱码
    username = request.getParameter("username");
    password = request.getParameter("password");


    //登陆成功，服务器内部转发到login_success.jsp
    if ("admin".equals(username) && "admin".equals(password)) {
        session.setAttribute("loginUser",username);
        request.getRequestDispatcher("login_success.jsp").forward(request, response);
    }
    //否则，重定向到login_fail.jsp
    else {
        response.sendRedirect("login_fail.jsp");
    }

%>
