package cn.ahaogg.web;

import cn.ahaogg.domain.User;
import cn.ahaogg.service.MachineService;
import cn.ahaogg.service.UserService;
import cn.ahaogg.utils.BeanFactory;
import cn.ahaogg.utils.IsEmpty;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "LoginServlet",urlPatterns = "/userservlet")
public class UserServlet extends BaseServlet{
    private UserService userService = BeanFactory.newInstance(UserService.class);
    private MachineService machineService = BeanFactory.newInstance(MachineService.class);
    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userEmail = request.getParameter("user_email");
        String userPwd = request.getParameter("user_pwd");
        User user = new User();
        Result result = new Result();
        try {
            user = userService.login(userEmail, userPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null){
            result.setCode(Result.FAILS);
            result.setMessage("fails");
        }else {
            result.setCode(Result.SUCCESS);
            result.setMessage("success");
            //设置session存在服务器
            HttpSession session = request.getSession();
            //持久化
            session.setAttribute("user",user);
            String id = session.getId();
            Cookie cookieid = new Cookie("JSESSIONID",id);
            cookieid.setMaxAge(60*10);
            cookieid.setPath(request.getContextPath());
            //cookie 携带Email 返回
            Cookie cookie = new Cookie("user_email",userEmail);
            //生命周期
            cookie.setMaxAge(60*60*10);
            //携带路径 为前项目下
            cookie.setPath(request.getContextPath());
            //返回user部分信息给安卓端
            user.setUser_pwd("");
            //返回cookie
            response.addCookie(cookie);
        }
        result.setObj(user);
        //返回json
        JSONObject fromObject = JSONObject.fromObject(result);
        response.getWriter().print(fromObject);
    }
    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> set = parameterMap.keySet();
        User user = new User();

        if (IsEmpty.isEmptyClient(parameterMap)) {
            try {
                BeanUtils.populate(user, parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            boolean register = userService.register(user);
            if (register) {
                Result result = new Result(Result.SUCCESS, "success");
                response.getWriter().print(JSONObject.fromObject(result));
            } else {
                Result result = new Result(Result.FAILS, "The email has been registered");
                response.getWriter().print(JSONObject.fromObject(result));
            }
        } else {
            Result result = new Result(Result.FAILS, "Please complete the registration");
            response.getWriter().print(JSONObject.fromObject(result));
        }
    }
    //忘记密码
    public void changPwd(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String mModel = request.getParameter("m_model");
        String userName = request.getParameter("user_name");
        String userEmail = request.getParameter("user_email");
        String userPhonenum = request.getParameter("user_phonenum");
        String userNewPwd = request.getParameter("user_new_pwd");
        String mSerialnum = request.getParameter("m_serialnum");
        int i = userService.changPwd(mModel,mSerialnum,userName, userEmail, userPhonenum, userNewPwd);
        //设置返回类 Result
        Result result = new Result();
        if (i>0){
            result.setCode(Result.SUCCESS);
            result.setMessage("SUCCESS");
        }else {
            result.setCode(Result.FAILS);
            result.setMessage("Information does not match");
        }
        //返回
        response.getWriter().print(JSONObject.fromObject(result));
    }

    //导出PDF(root用户)
    public void exportPDF(HttpServletRequest request,HttpServletResponse response) {

        List<User> list = null;
        list = userService.findUserAll();

        Document doc = new Document(PageSize.A4,10,10,20,20);
        ByteArrayOutputStream ba = new ByteArrayOutputStream();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, ba);
            doc.open();
            doc.addTitle("Hober");

        } catch (DocumentException e) {

            e.printStackTrace();

        }

        // 设置表格的列宽和列数
        float[] widths = {25f,25,20f,20f,20f};
        // 建立一个pdf表格
        PdfPTable table = new PdfPTable(widths);
        //
        table.setSpacingBefore(20f);
        // 设置表格宽度为100%
        table.setWidthPercentage(100);
        //PdfPTable table = new PdfPTable(5);
        //表格单元格默认设置
        table.getDefaultCell().setPadding(3);
        table.getDefaultCell().setBorderWidth(1);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setMinimumHeight(20);
        //单元格
        PdfPCell cell;
        //第一行表头
        cell = new PdfPCell(new Paragraph("User Information"));
        cell.setColspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);
        //第二行空行
        cell = new PdfPCell(new Paragraph("  "));
        cell.setColspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        table.addCell(cell);
        //第三行字段
        table.addCell("email");
        table.addCell("phone");
        table.addCell("password");
        table.addCell("name");
        table.addCell("country");
        //数据行
        for (User user : list) {
            table.addCell(user.getUser_email());
            table.addCell(user.getUser_phonenum());
            table.addCell(user.getUser_pwd());
            table.addCell(user.getUser_name());
            table.addCell(user.getUser_country());
        }
        //将表格添加进文档
        try {
            doc.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //关闭文档
        doc.close();

        //在浏览器进行下载
        response.setContentType("application/pdf");
        response.setContentLength(ba.size());
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            out.flush();
            ba.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //用户退出登录
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //销毁session
        request.getSession().invalidate();
        //设置cookie 销毁cookie
        Cookie cookie = new Cookie("user_email",null);
        //设置携带路径
        cookie.setPath(request.getContextPath());
        //设置生命周期
        cookie.setMaxAge(0);
        //覆盖原有cookie
        response.addCookie(cookie);
        Result result = new Result(Result.SUCCESS,"loginOut success");
        response.getWriter().print(JSONObject.fromObject(result));
    }
}
