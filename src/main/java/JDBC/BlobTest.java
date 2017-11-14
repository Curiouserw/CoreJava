package JDBC;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlobTest {
	public static void main(String[] args) throws Exception {
		select();
	}
	public static void insert() throws Exception {
		Connection conn = JDBCUtils.getConn();
		String sql="insert into blob_test values(?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, 1);
		FileInputStream fis=new FileInputStream("src/a.png");
		ps.setBinaryStream(2, fis);
		ps.executeUpdate();
		JDBCUtils.close(null, ps, conn);
	}
	public static void select() throws SQLException, IOException{
		Connection conn = JDBCUtils.getConn();
		System.out.println(conn.getMetaData());
		String sql="select id,bin_file from blob_test";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			InputStream in=rs.getBinaryStream(2);
			FileOutputStream out=new FileOutputStream("src/b.png");
			byte[] b=new byte[1024];
			int legth=0;
			while((legth=in.read(b))!=-1){
				out.write(b);
				out.flush();
			}
			out.close();
			in.close();
		}
		JDBCUtils.close(rs, ps, conn);
	}
}
