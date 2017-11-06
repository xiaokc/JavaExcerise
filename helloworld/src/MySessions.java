import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by xkc on 7/25/15.
 */
public class MySessions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("gb2312");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        Date assessed = new Date(session.getLastAccessedTime());
        Date created = new Date(session.getCreationTime());

        out.print("session id = "+session.getId()+"<br>");
        out.print("session created time = "+ created +"<br>");
        out.print("session assessed time = "+ assessed +"<br>");

        //设置session
        session.setAttribute("msg","hello session");

        //打印session的具体内容
        Enumeration e = session.getAttributeNames();
        out.print("session content:"+"<br>");
        while (e.hasMoreElements()){
            String name = (String) e.nextElement();
            String value = (String) session.getAttribute(name);

            out.print(name+"="+value);

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
