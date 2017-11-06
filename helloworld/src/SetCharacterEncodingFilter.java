import javax.servlet.*;
import java.io.IOException;

/**
 * 设置字符编码方式的过滤器，彻底解决中文乱码
 * Created by xkc on 7/10/15.
 */
public class SetCharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;
    private String encodingName;
    private boolean enable;

    public SetCharacterEncodingFilter(){
        this.encodingName = "gb2312";
        this.enable = false;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        loadConfigParams();
    }

    private void loadConfigParams() {
        //获取filter的两个参数
        this.encodingName = this.filterConfig.getInitParameter("encoding");
        String strIgnoreFlag = this.filterConfig.getInitParameter("enable");

        if (strIgnoreFlag.equalsIgnoreCase("true")){
            this.enable = true;
        }else {
            this.enable = false;
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (this.enable){
            servletRequest.setCharacterEncoding(this.encodingName);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
