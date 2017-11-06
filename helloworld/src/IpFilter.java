import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过Servlet的过滤器实现IP访问限制
 * Created by xkc on 7/9/15.
 */
public class IpFilter implements Filter{
    private FilterConfig filterConfig;
    private String ip;

    /**
     * 从配置文件中读取参数的内容
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.ip = this.filterConfig.getInitParameter("ip");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteIp = servletRequest.getRemoteAddr();
        if (remoteIp.equals(ip)){
            servletResponse.setCharacterEncoding("utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.print(new String("您的IP被禁止访问".getBytes("ISO-8859-1"),"gb2312"));
        }else {//如果IP合法，就允许访问,用户可以进入应用系统进行其他的操作。
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
