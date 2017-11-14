package JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.activation.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPTest {
	public static void main(String[] args) throws Exception {
		test();
	}
	public static void  test() throws Exception {
		BasicDataSource pool = new BasicDataSource();
		pool.setUrl("jdbc:mysql://localhost:3306/briup");
		pool.setUsername("root");
		pool.setPassword("*51158.");
		pool.setDriverClassName("com.mysql.jdbc.Driver");
		//设置最大连接数
		pool.setMaxTotal(5);
		//设置最大的空闲等待时间
		pool.setMaxIdle(5);
		//设置等待时间
		pool.setMaxWaitMillis(5000);
		//设置连接池的初始连接数
		pool.setInitialSize(5);
		
		Connection conn = pool.getConnection();
		System.out.println(conn);
	}
	public void test2() throws Exception{
		BasicDataSourceFactory factory=new BasicDataSourceFactory();
		Properties pro=new Properties();
		pro.load(new FileInputStream("src/conn_info.properties"));
		BasicDataSource pool=BasicDataSourceFactory.createDataSource(pro);
		Connection coon=pool.getConnection();
		
		
	}
}
