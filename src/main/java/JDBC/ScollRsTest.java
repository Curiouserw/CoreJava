package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ScollRsTest {
	public static void main(String[] args) throws SQLException {
		select();
	}
	public static void select() throws SQLException{
		Connection conn = JDBCUtils.getConn();
		java.sql.Statement stat = conn.createStatement();
		String sql="select id,name,balance from account where id<=10";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
		}
		System.out.println("==========");
		boolean b = rs.absolute(3);
		System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));

	}
}
