package servletLoginDemo;

import com.po.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xkc on 8/23/15.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users u = new Users();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        u.setUsername(username);
        u.setPassword(password);

        //System.out.println("username=" + username + ",password=" + password);
//        System.out.println("username="+u.getUsername()+",password="+u.getPassword());

//        System.out.println("contextPath="+req.getContextPath());

        HttpSession session = req.getSession();
        session.setAttribute("username", username);

//        服务器内部转发
        if (u.getUsername().equals("admin") && u.getPassword().equals("admin")){

            req.getRequestDispatcher(req.getContextPath()+"servletLoginDemo/login_success.jsp").forward(req,resp);

        }
//        重定向
        else {

            resp.sendRedirect(req.getContextPath()+"servletLoginDemo/login_fail.jsp");
        }

    }
}
