<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 6/29/15
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<%
    int first = 0;
    int second = 0;
    String firstParam = request.getParameter("first");
    String secondParam = request.getParameter("second");

    out.print("firstParam=" + firstParam + "<br>");
    out.print("firstParam-" + secondParam + "<br>");

    if (firstParam != null && firstParam.length() > 0) {
        first = Integer.parseInt(firstParam);

    }
    if (secondParam != null && secondParam.length() > 0) {
        second = Integer.parseInt(secondParam);
    }

    out.print("first=" + first + "<br>");
    out.print("second=" + second + "<br>");
%>
<html>
<head>
    <title>求和</title>
    <script type="text/javascript">
        <!--表单验证-->
        function check() {
//        var first = this.document.forms[0].first;
//        var second = this.document.forms[0].second;
           // this.document.forms[0].first;

            if (this.document.forms[0].first.value.length == 0) {
                alert("pls input the first num!");
            } else if (this.document.forms[0].second.value.length == 0) {
                alert("pls input the second num!");
            } else if (isNaN(this.document.forms[0].first.value)) {
                alert("first NaN!");
            } else if (isNaN(this.document.forms[0].second.value)) {
                alert("second NaN!");
            } else {
                this.document.forms[0].submit;
                alert("submit successful");
                //alert("first=" + first.value + ",second=" + second.value);
            }


        }
    </script>
</head>
<body>


<form action="add.jsp" method="post">
    求两个整数的和：<br>
    请输入第一个整数：<input type="text" name="first"><br>
    请输入第二个整数：<input type="text" name="second"><br>

    <%--<input type="submit" value="submit"> <br>--%>

    两个整数到和为：<%=(first + second) %>
    <input type="button" value="求和" onclick="check()">


</form>
</body>
</html>
