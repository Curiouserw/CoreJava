package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Results_update {
	public static void main(String[] args) throws SQLException {
		select();
	}
	public static void select() throws SQLException{
		Connection conn = JDBCUtils.getConn();
		java.sql.Statement stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String sql="select id,name,balance from account where id<=10";
		ResultSet rs=stat.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
			if(rs.getObject(2).equals("张三")){
				rs.updateInt(3,6666);
				rs.updateRow();
			}
		}
		JDBCUtils.close(rs,stat, conn);
	}
}
