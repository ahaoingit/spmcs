package cn.ahaogg.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

	//创建一个静态的ThreadLocal对象,存储Connection
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();

	public static Connection getConnection(){
		//从ThreadLocal中获取Connection
		Connection conn = tl.get();// get(当前线程)
		if(conn==null){
			try {
				//从连接池中获取Connection
				conn = dataSource.getConnection();
				//把获取到conn存储到ThreadLocal-->初始化一个Connection
				tl.set(conn); // put(当前线程,conn)
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static DataSource getDataSource(){
		return dataSource;
	}

	public static void close(ResultSet rs, Statement stat, Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();//把连接在归还给连接池
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
