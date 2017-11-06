import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xkc on 7/6/15.
 */
public class HelloTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<html>");
        out.print("<title>hello</title>");
        out.print("<body>");
        out.print("This just a servlet test");
        out.print("</body>");
        out.print("</html");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
