<%@ page import="com.entity.Items" %>
<%@ page import="com.dao.ItemsDao" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: xkc
  Date: 8/21/15
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页面</title>

    <style type="text/css">
        div {
            float: left;
            margin-top: 5px;
            margin-bottom: 5px;
            margin-left: 30px;
            margin-right: 30px;
        }

        div dd {
            margin: 0px;
            font-size: 10pt;
        }

        div dd.dd_name {
            color: blue;
        }

        div dd.dd_city {
            color: #000;
        }

        div dd.dd_price {
            color: #000;
            font-size: 15px;
        }


    </style>
</head>
<body>
<h1>商品详情页面</h1>
<hr>

<center>
    <table class="table" width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
            <%--商品详情--%>
            <%
                ItemsDao itemsDao = new ItemsDao();
                Items item = itemsDao.getItemById(Integer.parseInt(request.getParameter("id")));

                if (item != null) {


            %>
            <td width="70%" valign="top">
                <div>
                    <%--<dl></dl>用来创建一个普通的列表，<dt></dt>用来创建列表中的上层项目，<dd></dd>用来创建列表中最下层项目--%>
                    <dl>
                        <dt>
                            <img src="/images/<%=item.getPicture()%>"
                                 width="200" height="150"
                                 border="1">
                        </dt>
                        <dd class="dd_name"><%=item.getName()%>
                        </dd>
                        <dd class="dd_city">产地：<%=item.getCity()%>
                        </dd>
                        <dd class="dd_price">价格：¥<%=item.getPrice()%>
                        </dd>
                    </dl>
                </div>
            </td>
            <%
                }
            %>

            <%--浏览过的商品--%>
            <%
                String list = "";
                //从客户端获得Cookie集合
                Cookie[] cookies = request.getCookies();
                if (cookies != null && cookies.length > 0) {
                    //遍历Cookie集合
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("ListViewCookie")) {
                            list = cookie.getValue();
                        }
                    }
                }
                list += request.getParameter("id") + ",";
                //如果浏览记录超过1000条，就清空Cookie
                String[] arr = list.split(",");
                if (arr != null && arr.length > 0) {
                    if (arr.length >= 1000) {
                        list = "";
                    }
                }
                Cookie c = new Cookie("ListViewCookie", list);
                response.addCookie(c);

            %>

            <td width="30%" bgcolor="#EEE" >
                <br>
                <b>您浏览过的商品</b><br>

                <%--循环开始--%>
                <%
                    List<Items> itemsList = itemsDao.getViewList(list);
                    if (itemsList != null && itemsList.size() >= 0) {
                        for (Items i : itemsList) {
                %>
                <div>
                    <dl>
                        <dt>
                            <a href="details.jsp?id=<%=i.getId()%>"><img src="/images/<%=i.getPicture()%>" width="120"
                                                                         height="90" border="1"></a>
                        </dt>
                        <dd class="dd_name"><%=i.getName()%>
                        </dd>
                        <dd class="dd_city">产地:<%=i.getCity()%>&nbsp;&nbsp;价格：¥<%=i.getPrice()%>
                        </dd>
                    </dl>
                </div>
                <%
                        }
                    }
                %>
                <%--循环结束--%>

            </td>

        </tr>
    </table>
</center>
</body>
</html>
