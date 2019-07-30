package cn.ahaogg.web;

import cn.ahaogg.domain.Machine;
import cn.ahaogg.service.MachineService;
import cn.ahaogg.service.ModelService;
import cn.ahaogg.utils.BeanFactory;
import cn.ahaogg.utils.IsEmpty;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "machine", urlPatterns = "/machineservlet")
public class MachineServlet extends BaseServlet {
    private MachineService machineService = BeanFactory.newInstance(MachineService.class);
    private ModelService modelService = BeanFactory.newInstance(ModelService.class);

    //添加机器的方法
    public void addMachine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result result = new Result();
        Machine machine = new Machine();
        //获取请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装Machine
        if (IsEmpty.isEmptyClient(parameterMap)) {
            try {
                BeanUtils.populate(machine, parameterMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //型号转换为大写
            machine.setM_model(machine.getM_model().toUpperCase());
            //执行service
            boolean b = machineService.addMachine(machine);
            if (b) {
                result.setCode(Result.SUCCESS);
                result.setMessage("add success");
                JSONObject jsonObject = JSONObject.fromObject(result);
                response.getWriter().print(jsonObject);
            } else {
                result.setCode(Result.FAILS);
                result.setMessage("This machine already exists");
                response.getWriter().print(JSONObject.fromObject(result));
            }
        } else {
            response.getWriter().print(JSONObject.fromObject(new Result(Result.FAILS, "Please complete all spaces")));
        }
    }

    //查询用户的机械信息
    public void findMachineAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String user_email = null;
        //返回的list集合
        List<ModelInfo> modelInfoList = new ArrayList<>();
        //获取用户本地的cookie 得到user_email
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_email")) {
                user_email = cookie.getValue();
            }
        }
        //开始查询机械
        if (user_email == null) {
            response.getWriter().print(JSONObject.fromObject(new Result(Result.FAILS, "User_name is null")));
        } else {
            //封装到ModelInfo里
            List<Machine> machineAll = machineService.findMachineAll(user_email);
            if (machineAll.isEmpty()) {
                response.getWriter().print(new Result(Result.FAILS, "No machinery"));
            } else {
                for (Machine machine : machineAll) {
                    ModelInfo modelInfo = new ModelInfo();//放外面 就序列号 会覆盖前一个 ？？？
                    modelInfo.setM_serialnum(machine.getM_serialnum());
                    modelInfo.setModel(modelService.findModel(machine.getM_model()));
                    modelInfoList.add(modelInfo);
                }
                Result result = new Result(Result.SUCCESS, "Search successful");
                result.setObj(modelInfoList);
                response.getWriter().print(JSONObject.fromObject(result));
            }
        }
    }
}
