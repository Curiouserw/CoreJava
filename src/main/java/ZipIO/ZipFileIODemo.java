package ZipIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileIODemo {
	public static void main(String[] args) throws IOException {
		writeZipFile();
		
	}
	public static void writeZipFile() throws IOException {
		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/home/rm/Desktop/TestData.zip"));
		ZipEntry e = new ZipEntry("/home/rm/Desktop/TestData");
		zos.putNextEntry(e);
		zos.closeEntry();
		zos.close();
		
	}
	
	public static void	readZipFile() {
		
	}
}
