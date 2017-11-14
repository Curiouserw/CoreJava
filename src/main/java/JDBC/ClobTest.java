package JDBC;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClobTest {
	public static void main(String[] args) throws Exception {
		select();
	}
	public static void insert() throws Exception {
		Connection conn = JDBCUtils.getConn();
		String sql="insert into clob_test values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, 1);
		FileReader fr=new FileReader("src/jdk8.txt");
		ps.setCharacterStream(2, fr);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	public static void select() throws SQLException, IOException{
		Connection conn = JDBCUtils.getConn();
		String sql="select id,big_text from clob_test";
		System.out.println(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Reader reader = rs.getCharacterStream(2);
			FileWriter writer=new FileWriter("src/a.txt");
			int length=0;
			char[] c=new char[1024];
			while((length=reader.read(c))!=-1){
				writer.write(c);
				writer.flush();
			}
			
		}
		JDBCUtils.close(rs, ps, conn);
	}
}
