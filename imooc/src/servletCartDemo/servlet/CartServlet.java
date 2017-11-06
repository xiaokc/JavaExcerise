package servletCartDemo.servlet;

import servletCartDemo.dao.ItemsDao;
import servletCartDemo.entity.Cart;
import servletCartDemo.entity.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xkc on 8/30/15.
 */
public class CartServlet extends HttpServlet {
    private String action;//购物车的动作：add,delete,show
    private ItemsDao itemsDao = new ItemsDao();//商品业务逻辑类对象


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action") != null) {
            this.action = req.getParameter("action");
            if (action.equals("add")) {//添加商品进购物车
                if (addToCart(req, resp)) {
                    req.getRequestDispatcher("/servletCartDemo/success.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/servletCartDemo/fail.jsp").forward(req, resp);
                }
            }
            if (action.equals("delete")) {//无论删除成功还是失败，都跳转到购物车界面
                if (deleteFromCart(req, resp)) {
                    req.getRequestDispatcher("/servletCartDemo/cart.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("/servletCartDemo/cart.jsp").forward(req, resp);
                }
            }
            if (action.equals("show")) {//查看购物车
                showCart(req, resp);
            }
        }
    }

    /**
     * 显示购物车
     *
     * @param req
     * @param resp
     */
    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/servletCartDemo/cart.jsp").forward(req, resp);
    }

    /**
     * 从购物车删除商品
     *
     * @param req
     * @param resp
     */
    private boolean deleteFromCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Item item = itemsDao.getItemById(Integer.parseInt(id));
        if (cart.removeItemFromCart(item)) {
            return true;
        } else {

            return false;
        }
    }

    /**
     * 添加商品进购物车
     *
     * @param req
     * @param resp
     * @return
     */
    private boolean addToCart(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String number = req.getParameter("number");
        Item item = itemsDao.getItemById(Integer.parseInt(id));

        //判断是否是第一次给购物车添加商品，如果是第一次，需要在session中创建购物车对象
        if (req.getSession().getAttribute("cart") == null) {
            Cart cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart.addItemInCart(item, Integer.parseInt(number))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
