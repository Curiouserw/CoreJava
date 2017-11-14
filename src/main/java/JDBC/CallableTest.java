package JDBC;

import java.sql.*;

import com.mysql.jdbc.CallableStatement;

public class CallableTest {
	public static void main(String[] args) throws SQLException {
		procedure();
	}
	public static void procedure() throws SQLException{
		Connection conn=JDBCUtils.getConn();
		String sql="{call pr4(?,?)}";
		CallableStatement cs=(CallableStatement) conn.prepareStatement(sql);
		cs.setInt(1,100);
		cs.registerOutParameter(2,Types.INTEGER);
		cs.execute();
		int sum=cs.getInt(2);
		System.out.println(sum);
		JDBCUtils.close(null, cs, conn);
		
		
	}
}
