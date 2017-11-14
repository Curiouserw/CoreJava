package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.sql.Statement;

public class Tx_test {
	public static void main(String[] args) throws Exception {
		tx(1000);
	}
	public static void tx(float amount) throws Exception{
		 	Connection conn = JDBCUtils.getConn();
//		 	conn.setTransactionIsolation(Connection.XXX);
			conn.setAutoCommit(false);
			Statement stat = conn.createStatement();
			//第一个操作
		    String sql1="update account set balance = balance-"+amount+" where id = 2";
			stat.executeUpdate(sql1);
			//设置回滚点
			Savepoint sp1 = conn.setSavepoint("sp1");
			
			String sql2="update account set balance =  balance+"+amount+" where id = 1";
			stat.executeUpdate(sql2);
			
			String sql = "select balance from account where id = 1";
			ResultSet query = stat.executeQuery(sql);
			query.next();
			float ban = query.getFloat(1);
			if(ban<amount){
				conn.rollback(sp1);
				conn.commit();
//				conn.rollback();
				throw new RuntimeException("余额小于转账金额");
			}
			conn.commit();
	}
}
