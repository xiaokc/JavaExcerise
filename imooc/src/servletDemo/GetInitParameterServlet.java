package servletDemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xkc on 8/26/15.
 */
public class GetInitParameterServlet extends HttpServlet {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GetInitParameterServlet(){
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        //获取初始化参数
        this.setUsername(this.getInitParameter("username").toString());
        this.setPassword(this.getInitParameter("password").toString());
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//
//        //获取初始化参数
//        this.setUsername(this.getInitParameter("username").toString());
//        this.setPassword(this.getInitParameter("password").toString());
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<HTML>");
        out.println("<head><title>This is a servlet</title></head>");
        out.println("<body>");
        out.println(this.getClass()+"<br>");
        out.println("use post method"+"<br>");
        out.println("<h1>"+"username:"+this.getUsername()+"<h2>"+"<br>");
        out.print("<h1>"+"username:"+this.getPassword()+"<h2>"+"<br>");
        out.println("</body>");
        out.println("</HTML>");
    }
}
