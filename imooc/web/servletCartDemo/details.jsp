<%@ page import="java.util.*" %>
<%@ page import="servletCartDemo.entity.Item" %>
<%@ page import="servletCartDemo.dao.ItemsDao" %>
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
    <script type="text/javascript">
        function add() {
            var num = parseInt(document.getElementById("number").value);
            if (num < 100) {
                document.getElementById("number").value = ++num;
            }
        }

        function sub() {
            var num = parseInt(document.getElementById("number").value);
            if (num > 1) {
                document.getElementById("number").value = --num;
            }
        }

        function selflog_show(id) {
//            console.log("xkc", "selflog_show() is called");
            var num = document.getElementById("number").value;

//            直接在原窗口打开
//            location.href = "/imooc/servletCartDemo/servlet/CartServlet?id=" + id + "&number=" + num + "&action=add";

            //用模态窗口弹出，浏览器无法解析J
//            J.dialog.get({
//                id: 'add_success', title: '添加成功', width: 600, height: 400,
//                link: '/imooc/servletCartDemo/servlet/CartServlet?id=' + id + '&number=' + num + '&action=add', cover: true
//            });

            var url = "/imooc/servletCartDemo/servlet/CartServlet?id=" + id + "&number=" + num + "&action=add";
            var iHeight = 400;
            var iWidth = 600;
            var iTop = (window.screen.availHeight - iHeight)/2;//获得窗口的垂直位置
            var iLeft = (window.screen.availWidth - iWidth)/2;//获得窗口的水平位置


//            var url = '/imooc/servletCartDemo/servlet/CartServlet?id=2&number=2&action=add';
            window.open(url, "add", "height＝"+iHeight+",width="+iWidth+",top="+iTop+",left="+iLeft);

//            window.showMadalDialog已经废弃，google浏览器不能识别，safari可以
//            window.showModalDialog(url, "dialogWidth=400px;dialogHeight=300px;center=yes;help=no;resizable=1;status=no;scroll=no");

        }

    </script>


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

        div dd.dd_num {
            color: crimson;
            font-size: 18px;
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
                Item item = itemsDao.getItemById(Integer.parseInt(request.getParameter("id")));

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
                        <dd class="dd_num">
                            购买数量：<span id="sub" onclick="sub();" style="cursor: pointer;">-</span>
                            <input type="text" id="number" name="number" value="1" size="5">
                            <span id="add" onclick="add();" style="cursor: pointer">+</span>

                        </dd>

                        <dd>
                            <img src="/images/buy_now.png"/>
                            <a href="javascript:selflog_show(<%=item.getId()%>)">
                                <img src="/images/in_cart.png"></a>
                            <a href="/imooc/servletCartDemo/servlet/CartServlet?action=show">
                                <img src="/images/view_cart.jpg"></a>
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

            <td width="30%" bgcolor="#EEE">
                <br>
                <b>您浏览过的商品</b><br>

                <%--循环开始--%>
                <%
                    List<Item> itemsList = itemsDao.getViewList(list);
                    if (itemsList != null && itemsList.size() >= 0) {
                        for (Item i : itemsList) {
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
