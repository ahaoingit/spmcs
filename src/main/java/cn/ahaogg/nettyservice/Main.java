package cn.ahaogg.nettyservice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Server start");
		try {
			new NettyServer().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
