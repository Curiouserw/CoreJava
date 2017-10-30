package Files;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

public class MermoryMapTest {
	public static long checksumInputStream(Path filename) throws IOException {
		try(InputStream inputStream=Files.newInputStream(filename)){
			CRC32 crc = new CRC32();
			int c;
			while ((c=inputStream.read())!=-1) 
				crc.update(c);
			return crc.getValue();
		}
	}
	public static long checksumBufferedInputStream(Path filename) throws IOException {
		try(InputStream inputStream=new BufferedInputStream(Files.newInputStream(filename))){
			CRC32 crc = new CRC32();
			int c;
			while ((c=inputStream.read())!=-1) 
				crc.update(c);
			return crc.getValue();
		}
	}
	
	public static long checksumRandomAccessFile(Path filename) throws IOException {
		try(RandomAccessFile file=new RandomAccessFile(filename.toFile(),"r")){
			
			long length = file.length();
			CRC32 crc = new CRC32();
			for (long p = 0; p < length; p++) {
				file.seek(p);
				int c = file.readByte();
				crc.update(c);
			}
			return crc.getValue();
		}
	}
	
	public static long checksumMappedFile(Path filename) throws IOException {
		try(FileChannel channel = FileChannel.open(filename)){
			CRC32 crc = new CRC32();
			int length = (int) channel.size();
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
			for (int i = 0; i < length; i++) {
				int b = buffer.get(i);
				crc.update(b);
			}
			return crc.getValue();
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(args[0]);

		
		System.out.println("Input Stream:");
		long start = System.currentTimeMillis();
		long crcValue = checksumInputStream(path);
		long end =System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
		
		System.out.println("=================");
		System.out.println("Buffered Input Stream:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(path);
		end =System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");

		System.out.println("=================");
		System.out.println("Random Access File:");
		start = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(path);
		end =System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
		

		System.out.println("=================");
		System.out.println("Mapped File:");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(path);
		end =System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end-start)+" milliseconds");
	}
}

