package IO;

import java.io.File;
import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;

public class IOFile {

	public static void main(String[] args) throws IOException {
		//File��Ĺ��췽��
//		File a=new File("c:\\1.txt");
//		File file=new File("c:\\","1.txt");
//		File dir=new File("c:\\");
//		File file1=new File(dir,"1.txt");
//	 	System.out.println(file2);
		
		
//		File file2=new File("C:"+File.separator+"Users"+File.separator+"RM.RATIONALMONSTER"+File.separator+"Desktop"+File.separator+"linuxϵͳ.txt");
		
		File file=new File("e:\\hah.txt");
		System.out.println(file.getFreeSpace());
		
		File file3=new File("e:\\abc\\d\\e");
	
		File file4=new File("abc.txt");
		
//		FileMethodDemo1(file2);
		FileMethodDemo2(file,file3,file4);
		
	}

	private static void FileMethodDemo2(File file,File file3,File file4) throws IOException {
		//�ļ��Ĵ�����������ļ����ھͷ���false)
//		boolean b=file.createNewFile();
//		System.out.println(b);
		
		
		//ɾ���ļ�  (ֱ�Ӵ�Ӳ����ɾ�� /�ļ����ڱ�ʹ��ʱ�޷�ɾ��)
//		boolean c=file.delete();
//		System.out.println(c);
		
//		//�ж��ļ��Ƿ����
//		boolean d=file.exists();
//		System.out.println(d);
		
		//�����ļ���  file.mkdirs()--�����༶Ŀ¼
//		boolean e=file3.mkdirs();
//		System.out.println(e);
		
		//Ŀ¼������������ݲ���ֱ��ɾ��
//		boolean f=file3.delete();
//		System.out.println(f);
		
//		boolean g=file4.exists();
//		System.out.println("dir:"+g);
//		
//		boolean h=file4.mkdir();
//		System.out.println(h);
//		System.out.println(file4.isDirectory());
//		System.out.println(file4.isFile());
		
	}

//	private static void FileMethodDemo1(File file2) {
//		//��ȡ�ļ���
//		String file_name=file2.getName();
//		System.out.println(file_name);
//		
//		//��ȡ�ļ���С
//		long file_size=file2.length();
//		System.out.println(file_size);
//		
//		//��ȡ�ļ�����Ŀ¼��Ŀ¼
//		String file_parentdir=file2.getParent();
//		System.out.println(file_parentdir);
//		
//		
//		//��ȡ�ļ��ڴ����ϵľ���·��
//		String filepath=file2.getAbsolutePath();
//		System.out.println(filepath);
//		
//		
//		//��ȡ�ļ��ķ�װ·��
//		String path=file2.getPath();
//		System.out.println(path);
//		
//		//��ȡ�ļ�����޸�ʱ�䲢��ʽ��ʱ��ֵ
//		long file_time=file2.lastModified();
//		Date date=new Date(file_time);
//		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
//		String str_date=dateFormat.format(date);
//		System.out.println(str_date);
//		
//		//�ж��ļ��Ƿ����
//		boolean b=file2.isHidden();
//		System.out.println(b);
//	}
	
}
