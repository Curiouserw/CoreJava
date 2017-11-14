package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DteTest {
	public static void main(String[] args) throws Exception {
		select();
	}
	public static void select() throws Exception {
		//1:向DriverManager注册mysql驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2:通过DriverManager的getConnection方法获得连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/briup","root","*51158.");
		String sql="select last_name,salary,start_date from s_emp where start_date = ?";
		System.out.println(sql);
		//3:生成sql容器
		PreparedStatement ps=conn.prepareStatement(sql);
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse("1991-01-01");
		java.sql.Date sdate=new java.sql.Date(date.getTime());
		
		ps.setDate(1,sdate);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			java.sql.Date start_date= rs.getDate(3);
			System.out.println(start_date);
			java.sql.Date start_date2=new java.sql.Date(start_date.getTime());
		}
		rs.close();
		ps.close();
		conn.close();
	}
}
