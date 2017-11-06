import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by xkc on 7/6/15.
 */
public class FileRead extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setCharacterEncoding("gb2312");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        //content.txt的路径：/Users/xkc/IdeaProjects/test/out/artifacts/helloworld_war_exploded

        String fileName = "content.txt";
        String filePath = req.getRealPath(fileName);

        System.out.println("content.txt filePath = "+filePath);

        File file = new File(filePath);
        if (file.exists()){
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                out.print(line+"<br>");
            }
        }else {
            out.print("This file is not exist!"+"<br>");
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
