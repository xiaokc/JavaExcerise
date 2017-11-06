import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xkc on 7/23/15.
 */
public class RequestInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>请求信息例子title</title>");
        out.print("</head>");
        out.print("<body><font size = '2'>");
        out.print("<b>请求信息例子body</b>");
        out.print("Method:"+req.getMethod()+"<br>");
        out.print("Request URI:"+req.getRequestURI()+"<br>");
        out.print("Protocol:"+req.getProtocol()+"<br>");
        out.print("Remote Address:"+req.getRemoteAddr()+"<br>");
        out.print("</font></body>");
        out.print("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
