package JDBC;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;


public final class JDBCUtils {
	private static String driver="";
	private static String url="";
	private static String user="";
	private static String password="";
	private static Connection conn=null;
	
//	private static JDBCUtils ju=null;
//	public static JDBCUtils newInstance() {
//		if(ju==null){
//			synchronized (JDBCUtils.class) {
//				if(ju==null){
//					ju=new JDBCUtils();
//				}
//			}
//		}
//		return ju;
//	}
	
	static{
		try {
			Properties p=new Properties();
			p.load(new FileInputStream("src/conn_info.properties"));
			url=p.getProperty("url");
			driver=p.getProperty("driver");
			user=p.getProperty("user");
			password=p.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	private void JDBCUtils(){}
	public static Connection getConn(){
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,java.sql.Statement stat,Connection conn){
		try {
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
