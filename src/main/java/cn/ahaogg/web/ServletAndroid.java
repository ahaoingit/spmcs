package cn.ahaogg.web;

import cn.ahaogg.domain.Machine;
import cn.ahaogg.domain.Model;
import cn.ahaogg.domain.RealTime;
import cn.ahaogg.domain.User;
import cn.ahaogg.service.MachineService;
import cn.ahaogg.service.ModelService;
import cn.ahaogg.service.RealTimeService;
import cn.ahaogg.service.UserService;
import cn.ahaogg.utils.BeanFactory;
import cn.ahaogg.utils.ConvertUtils;
import net.sf.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletServletAndroid" , urlPatterns = "/getInfo")
public class ServletAndroid extends BaseServlet {
    private UserService userService= BeanFactory.newInstance(UserService.class);
    private ModelService modelService = BeanFactory.newInstance(ModelService.class);
    private MachineService machineService = BeanFactory.newInstance(MachineService.class);
    private RealTimeService realTimeService = BeanFactory.newInstance(RealTimeService.class);

    //获取信息
    public void  getInfo(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        String userEmail = request.getParameter("user_email");
        User user;
        //返回机械信息
        List<ModelInfo> modelInfos = new ArrayList<>();
        //用于返回
        Result result = new Result();
        //获取用户类
        user = userService.findUser(userEmail);
        //改变user密码返回
        user.setUser_pwd(null);
        //通过用户email 获取 用户所有机器
        List<Machine> machineAll = machineService.findMachineAll(user.getUser_email());
        //通过machine 获取 机械信息
        for (Machine machine : machineAll) {
            Model mofel = modelService.findModel(machine.getM_model());
            modelInfos.add(new ModelInfo(machine.getM_serialnum(),mofel));
        }
        result.setObj(modelInfos);
        JSONObject jsonObject = JSONObject.fromObject(result);
        response.getWriter().print(jsonObject);
    }

    //实时数据
    //安卓端单独根据序列号查实时数据
    public void getRealTime(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {
        String m_serialNum = request.getParameter("m_serialnum");
        RealTime realTime = realTimeService.findRealTime(m_serialNum);
        System.out.println(realTime);
        //设置返回类 Result
        Result result = new Result();
        if (realTime!=null){
            result.setCode(Result.SUCCESS);
            result.setMessage("SUCCESS");
            realTime.setF_code(ConvertUtils.errorConvertString(realTime.getF_code()));
            realTime.setW_code(ConvertUtils.errorConvertString(realTime.getW_code()));
            realTime.setS_code(ConvertUtils.switchConvertString(realTime.getS_code()));
            result.setObj(realTime);
        }else {
            result.setCode(Result.FAILS);
            result.setMessage("FAIL");
        }
        System.out.println(result);
        //返回
        response.getWriter().print(JSONObject.fromObject(result));
    }

}
