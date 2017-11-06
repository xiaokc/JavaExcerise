import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by xkc on 7/6/15.
 */
public class FileWrite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setCharacterEncoding("gb2312");
        resp.setContentType("text/html");

        PrintWriter  out = resp.getWriter();
        String fileName = "new.txt";
        String filePath = req.getRealPath(fileName);

        System.out.println("new.txt filePath = "+filePath);


        File file = new File(filePath);

        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("This is a new file.");
        bufferedWriter.newLine();//实现换行
        bufferedWriter.write("Just for a writer test");
        bufferedWriter.newLine();
        bufferedWriter.write("best wishes!");

        bufferedWriter.flush();
        bufferedWriter.close();

        out.print("This file is writed successful,the path is "+file.getAbsolutePath()+"<br>");




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        doGet(req,resp);
    }
}
