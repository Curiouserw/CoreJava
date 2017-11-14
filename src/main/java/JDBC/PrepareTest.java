package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareTest {
	public static void main(String[] args) throws Exception {
		insert();
	}
	public static void insert() throws Exception{
		String url = "jdbc:mysql://localhost:3306/briup";
		String user = "root";
		String password = "*51158.";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(
				url,user,password);
//		System.out.println(conn);
		//ŽËÊ±sqlÊÇÒ»ÖÖœá¹¹
		//Õâžöœá¹¹ÖÐÈ±ÉÙÁË²ÎÊýÖµ
		//£¿ÕŒÎ»·û£¬Žú±íÄ³Ò»žö²ÎÊý
		String sql = "insert into s_emp(id,last_name,salary) values"
				+ "(?,?,?)";
//		System.out.println(sql);
		PreparedStatement pre = conn.prepareStatement(sql);
//		pre.setInt(1, 27);
//		pre.setString(2, "zhangsan");
//		pre.setFloat(3, 10000.0f);
		
		long b = System.currentTimeMillis();
		
		for(int i=0;i<20000;i++){
			pre.setInt(1, i+27);
			pre.setString(2, "briup"+i);
			pre.setFloat(3, (float)i);
			
			pre.execute();
			
		}
		long a = System.currentTimeMillis();
		
		System.out.println("ŒäžôÊ±Œä£º"+(a-b));
//		pre.executeQuery();
//		pre.executeUpdate();
		
		pre.close();
		conn.close();
	}
}