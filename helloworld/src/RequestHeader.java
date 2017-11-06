import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 获取请求信息头部内容
 * Created by xkc on 7/14/15.
 */
public class RequestHeader extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Enumeration e = req.getHeaderNames();
        while(e.hasMoreElements()){
            String name = e.nextElement().toString();
            String value = req.getHeader(name);
            out.print(name + "=" + value + "<br>");
        }



    }
}
