package cn.ahaogg.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLEncoder;

public class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=utf-8");
            //获取客户端提交数据,方法名
            String md = request.getParameter("method");
            Class clazz = this.getClass();
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        }catch (Exception ex){ex.printStackTrace();}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
