<%@ page import="servletCartDemo.entity.Cart" %>
<%@ page import="servletCartDemo.entity.Item" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/31/15
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <link type="text/css" rel="stylesheet" href="/css/style1.css">
    <script language="JavaScript">
        function delfun() {
            if (!confirm("确认删除吗？")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body>
<h1>我的购物车</h1>
<a href="/servletCartDemo/index.jsp">首页</a> >> <a href="/servletCartDemo/index.jsp">商品列表</a>
<hr>
<div id="shopping">
    <form action="" method="">
        <table>
            <tr>
                <th>商品名称</th>
                <th>商品单价</th>
                <th>商品价格</th>
                <th>购买数量</th>
                <th>操作</th>
            </tr>

            <%
                if (request.getSession().getAttribute("cart") != null) {

            %>

            <%--循环开始--%>
            <%
                Cart cart = (Cart) request.getSession().getAttribute("cart");

                Map<Item, Integer> goods = cart.getGoods();
                Set<Map.Entry<Item, Integer>> entrySet = goods.entrySet();
                Iterator<Map.Entry<Item, Integer>> iterator = entrySet.iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Item, Integer> entry = iterator.next();
                    Item item = entry.getKey();
                    int number = entry.getValue();


            %>
            <tr name="products" id="product_id_1">
                <td class="thumb"><img src="/images/<%=item.getPicture()%>" width="120" height="90" border="1">
                    <a href=""><%=item.getName()%>
                    </a></td>
                <td class="number"><%=item.getPrice()%>
                </td>
                <td class="price" id="price_id_1"><span><%=item.getPrice() * number%></span><input type="hidden"
                                                                                                   value=""></td>
                <td class="number"><%=number%>
                </td>
                <td class="delete">
                    <a href="/imooc/servletCartDemo/servlet/CartServlet?action=delete&id=<%=item.getId()%>"
                       onclick="delfun();">删除</a>
                </td>
            </tr>
            <%--循环结束--%>
            <%

                }

            %>

        </table>

        <div class="total"><span id="total">总计：¥<%=cart.getTotalPrice()%></span></div>
        <%
            }
        %>
        <div class="button"><input type="submit" value="提交订单"></div>

    </form>
</div>

</body>
</html>
