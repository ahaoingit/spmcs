package cn.ahaogg.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.ahaogg.web.listener.SocketListener;

public class StartNettyServer implements ServletContextListener{
	public static SocketListener socketListener;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		socketListener = new SocketListener();
		sce.getServletContext().setAttribute("SocketListener", socketListener);
		System.out.println("Netty服务启动");
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("服务器关闭");
	}
}
