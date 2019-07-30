package cn.ahaogg.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//只过滤主页，不只一个主页的话，改成/*.jsp
@WebFilter(filterName = "Filter",urlPatterns = "/index.jsp")
public class Filter implements javax.servlet.Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /**
     * 拦截请求，看看用户是否登陆，如果没有登陆，
     * 则跳转回登录页面，否则就放行
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取根目录所对应的绝对路径
        String currentURL = request.getRequestURI();
        //截取到当前文件名用于比较
        String targetURL = currentURL.substring(currentURL.indexOf("/",1),currentURL.length());
        //如果session不为空就返回该session，如果为空就返回null
        HttpSession session = request.getSession(false);
        if(!"/login.jsp".equals(targetURL)){
            //判断当前页面是否是重定向后的登陆页面页面，如果是就不做session的判断，防止死循环
            if(session==null||session.getAttribute("user")==null){
                //如果session为空表示用户没有登陆就重定向到login.jsp页面
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                return;
            }
        }
        //继续向下执行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}