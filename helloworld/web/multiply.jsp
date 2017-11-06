<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 7/1/15
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.jsp.*" %>
<%@ page import="java.io.IOException" %>
<html>
<head>
    <title></title>
</head>
<body>
<%!
    //返回九九乘法表对应的HTML代码，通过表达式来调用，在页面上显示
    String printMultiplyTable1() {
        String s = "";
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= i; j++) {
                s += i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
            }
            s += "<br>";//追加换行标签
        }
        return s;
    }

    //JSP内置out对象，使用脚本方式打印九九乘法表
    void printMultiplyTable2(JspWriter out) {
        String s = "";
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= i; j++) {
                try {
                    out.print(i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                out.print("<br>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


%>
<script language="JavaScript">
    <%
  %>
</script>

<!--
-->
<h1>九九乘法表</h1>
<hr>
<!--以表达式方式调用-->
<%=printMultiplyTable1()%>
<!--以脚本方式调用，分号结束-->
<hr>
<%
    printMultiplyTable2(out);
%>
</body>
</html>
