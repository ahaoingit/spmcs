package cn.ahaogg.web;

import cn.ahaogg.domain.Machine;
import cn.ahaogg.domain.RealTime;
import cn.ahaogg.service.MachineService;
import cn.ahaogg.service.RealTimeService;
import cn.ahaogg.utils.BeanFactory;
import net.sf.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RealTimeServlet", urlPatterns = "/realtimeservlet")
public class RealTimeServlet extends BaseServlet {
    private RealTimeService realTimeService = BeanFactory.newInstance(RealTimeService.class);
    private MachineService machineService = BeanFactory.newInstance(MachineService.class);

    //制图用
    public void findRealTimeAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String time = request.getParameter("time");
        String m_serialnum = request.getParameter("m_serialnum");
        List<RealTime> realTimeAll = realTimeService.findRealTimeAll(m_serialnum, time);
        if (realTimeAll.isEmpty()) {
            response.getWriter().print(JSONObject.fromObject(new Result(Result.FAILS, "No Data")));
        } else {
            Result result = new Result(Result.SUCCESS, "Loading");
            result.setObj(realTimeAll);
            response.getWriter().print(JSONObject.fromObject(result));
            System.out.println(JSONObject.fromObject(result));
        }
    }

    //实时数据
    public void getRealTime(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        String user_email = null;
        //获取cookie中的email
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_email")) {
                user_email = cookie.getValue();
            }
        }
        //得到每一台机械信息 存在 List 内
        List<RealtimeInfo> realtimeInfos = new ArrayList<>();
        List<Machine> machineAll = machineService.findMachineAll(user_email);
        if (machineAll.isEmpty()) {
            response.getWriter().print(new Result(Result.FAILS, "No machinery"));
        } else {
            for (Machine machine : machineAll) {
                RealtimeInfo realtimeInfo = new RealtimeInfo();
                String m_model = machine.getM_model();
                RealTime realTime = realTimeService.findRealTime(machine.getM_serialnum());
                realtimeInfo.setM_model(m_model);
                realtimeInfo.setRealTime(realTime);
                //判断机械是否有真实数据
                if (null != realtimeInfo.getRealTime()) {
                    realtimeInfos.add(realtimeInfo);
                }
            }
            Result result = new Result(Result.SUCCESS,"Research successful");
            result.setObj(realtimeInfos);
            response.getWriter().print(JSONObject.fromObject(result));
        }
    }
}
