package JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class MetaData {
	public static void main(String[] args) throws SQLException {
		metaDatad();
	}
	public static void metaDatad() throws SQLException {
		Connection conn = JDBCUtils.getConn();
		DatabaseMetaData metaData = conn.getMetaData();
		System.out.println(metaData.getDatabaseProductName()+" + "+metaData.getDatabaseMajorVersion()+" $ "+metaData.getDefaultTransactionIsolation());
		java.sql.PreparedStatement stat = conn.prepareStatement(null);
		ResultSetMetaData statMetaDsata = stat.getMetaData();
		System.out.println(statMetaDsata.getColumnCount());
	}
}
