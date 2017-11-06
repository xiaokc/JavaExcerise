import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 文件下载
 * Created by xkc on 7/9/15.
 */
public class FileDownload extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String fName = "content.txt";
            resp.setCharacterEncoding("utf-8");
            fName = java.net.URLEncoder.encode(fName,"utf-8");
            resp.setHeader("Content-Disposition","attachment; filename="+fName);
            resp.setContentType("text/html");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
