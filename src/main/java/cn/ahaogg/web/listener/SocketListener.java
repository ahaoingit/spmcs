package cn.ahaogg.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.ahaogg.nettyservice.NettyServer;
import cn.ahaogg.service.ControlService;
import cn.ahaogg.web.interface1.NettyCommunicate;

import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SocketListener implements ControlService{
	private NettyServer nettyServer;
	private NettyCommunicate nettyCommunicate;
	
	public SocketListener() {
		
		nettyServer = new NettyServer();
		
		//初始化 启动 socket 线程
        new Thread(){
            public  void  run(){
        		try {
        			nettyCommunicate = nettyServer;
        			nettyServer.start();   // 启动 netty服务
        			      				
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
        }.start();
		
	}

   /* @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化 启动 socket 线程
        new Thread(){
            public  void  run(){
            	System.out.println("Netty server start");
        		try {
        			nettyServer.start();   // 启动 netty服务
        			nettyCommunicate = (NettyCommunicate) nettyServer;      				
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
        }.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("服务器关闭");
    }
    */

	@Override
	public String sendInstruction(String mSerialNum, String instruction) {
		// TODO Auto-generated method stub
		return nettyCommunicate.sendMsg(mSerialNum, instruction);

	}
    
}
