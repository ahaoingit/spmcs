package cn.ahaogg.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ahaogg.service.ControlService;
import cn.ahaogg.utils.BeanFactory;

@WebServlet(name = "control" , urlPatterns = "/controlservlet")
public class ControlServlet extends BaseServlet {
	
	// 发送指令的方法
	public void sendInstructions(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ControlService controlService = (ControlService) this.getServletContext().getAttribute("SocketListener");
		String mSerialNum = request.getParameter("m_serialnum");
		String instruction = request.getParameter("instruction");
		String result = controlService.sendInstruction(mSerialNum, instruction);
		response.getWriter().print(result);
	}
		
}
