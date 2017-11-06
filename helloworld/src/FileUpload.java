import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * 使用第三方组件commons-fileupload实现文件上传
 * Created by xkc on 7/6/15.
 */
public class FileUpload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("doGet() is called");
        //判断提交过来的表单是否是文件上传表单
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        System.out.println("isMultipart="+isMultipart);
        if (isMultipart){

            //这两行代码构建一个文件上传处理的对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            Iterator items;
            try {
                //解析出表单中所有的文件内容
                items = (Iterator) upload.parseRequest(req).iterator();

                System.out.println("items.hasNext()="+ items.hasNext());

                while (items.hasNext()){
                    FileItem item = (FileItem) items.next();
                    System.out.println("item.isFormField()"+item.isFormField());
                    if (!item.isFormField()){
                        //取出上传文件的文件名称
                        String name = item.getName();
                        String fileName = name.substring(name.lastIndexOf("\\") + 1, name.length());//文件名
                        //文件上传到服务器后的存储路径:/Users/xkc/IdeaProjects/test/out/artifacts/helloworld_war_exploded/file/
                        String path = req.getRealPath("file") + File.separatorChar + fileName;

                        //上传文件
                        File uploadedFile = new File(path);
                        //将上传到文件存储到服务器
                        item.write(uploadedFile);

                        System.out.println("文件已经上传");

                        //打印上传成功的信息
                        resp.setContentType("text/html");
                        resp.setCharacterEncoding("gb2312");
                        PrintWriter out = resp.getWriter();
                        //out.print("上传的文件是：" + new String(name.getBytes("ISO-8859-1"),"gb2312" +"<br>"));
                        out.print("保存的地址是：" + path);

                    }
                }
            } catch (FileUploadException e) {
                //e.printStackTrace();
                System.out.println("文件上传异常");
            } catch (Exception e) {
                //e.printStackTrace();
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("doPost() is called");
        doGet(req,resp);
    }
}
