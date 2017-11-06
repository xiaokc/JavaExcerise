import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet ac
 * Created by xkc on 7/6/15.
 */
public class AcceptForm extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");

        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String province = req.getParameter("province");

        out.print("提交表单的内容：<br>");
        out.print("name:"+name+"<br>");
        out.print("province:"+province+"<br>");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
