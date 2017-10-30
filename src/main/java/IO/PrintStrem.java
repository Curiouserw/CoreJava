package IO;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintStrem {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter("/home/rm/Desktop/TestData/printeriter");
		printWriter.println("PrintWriterDemo");
		printWriter.print(5);
		printWriter.close();		
	}
}
