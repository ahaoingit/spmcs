package cn.ahaogg.web;

import cn.ahaogg.domain.Model;
import cn.ahaogg.service.ModelService;
import cn.ahaogg.utils.BeanFactory;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns = "/modelServlet")
public class ModelServlet extends BaseServlet {
    //反射获得ModelService 的实现类
    private ModelService modelService = BeanFactory.newInstance(ModelService.class);

    //获取Model信息
    public void findModel(HttpServletRequest request , HttpServletResponse response){
        String mModel = request.getParameter("m_model");
        Model model = modelService.findModel(mModel);
       try {
           //返回json格式的Model信息
           JSONObject jsonObject = JSONObject.fromObject(model);
           response.getWriter().print(jsonObject);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
