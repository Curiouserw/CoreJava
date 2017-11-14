package JDBC;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.dbutils.QueryLoader;

public class DBUtils {
	public static void main(String[] args) {
		
	}
	public void test3() throws Exception{
		Map<String, String> load = QueryLoader.instance().load("src/a.properties");
		
	}
}
