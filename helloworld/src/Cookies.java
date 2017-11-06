import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xkc on 7/25/15.
 */
public class Cookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");

        PrintWriter out = resp.getWriter();

        Cookie cookie = new Cookie("name", "xkc");
        resp.addCookie(cookie);

        //打印cookie的内容
        Cookie[] cookies = req.getCookies();

        out.print("Cookie内容：<br>");
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];

            String name = c.getName();
            String value = c.getValue();

            out.print(name+"="+value+"<br>");
        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
