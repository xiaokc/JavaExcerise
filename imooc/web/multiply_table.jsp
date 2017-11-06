<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/9/15
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.IOException" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
<script language="JavaScript">

</script>
<%!
    //表达式
    private String print_1() {
        String s = "";
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                s += i + "*" + j + "=" + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";
            }
            s += "<br>";
        }
        return s;
    }

    //    脚本
    private void print_2(JspWriter out) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
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
<h1>
    九九乘法表
</h1>
<%--中间加条分割横线--%>
<hr>
<%--表达式法输出九九乘法表--%>
<%=print_1()%>

<%--脚本的形式输出九九乘法表--%>
<hr>
<%
print_2(out);
%>
</body>
</html>

