import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by xkc on 7/23/15.
 */
public class RequestParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");
        PrintWriter out = resp.getWriter();
        Enumeration e = req.getParameterNames();
        out.print("下面是Get方法传递的参数:<br>");
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            String value = req.getParameter(name);
            out.print("name="+name+",value="+value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");
        PrintWriter out = resp.getWriter();
        Enumeration e = req.getParameterNames();
        out.print("下面是post方法传递的参数:<br>");
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            String value = req.getParameter(name);
            out.print("name="+name+",value="+value);
        }
    }
}
