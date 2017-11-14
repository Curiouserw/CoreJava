package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Auto_increment {
	public static void main(String[] args) throws Exception {
		select();
	}
	public static void select() throws SQLException{
		Connection conn = JDBCUtils.getConn();
		String sql="insert into person(name,gender) values('ls',0)";
		PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();
		while(rs.next()){
			System.out.println(rs.getObject(1));
		}
		JDBCUtils.close(rs, ps, conn);
		
	} 
}
