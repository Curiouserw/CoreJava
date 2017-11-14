package IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import IO.FilterByContain;
import IO.FilterBySuffix;

public class FileDemo2 {

	public static void main(String[] args) {
		// ��ȡָ���ļ����µ������ļ��м��ļ������ƣ��޷���ȡ��С
//		File dir=new File("f:\\a");
//		String []names=dir.list();//�г���ǰĿ¼�µ����е��ļ����ļ���
//		System.out.println(names);
//		if(names!=null)
//		for(String name : names){
//			System.out.println(name);
//		}
		
		
//		File b=new File("f:\\a");
//		File[] dirs=b.listFiles();
//		for(File a : dirs){
//			System.out.println(a+"...size:"+a.length());
//		}
		
		
		File c=new File("f:\\a");
//		FilenameFilter filter=new FilterBySuffix(".docx");
		
		//����һ������������
//		FilenameFilter filter=new FilterByContain("d");
		
		
		String[] directory=c.list(new FilterBySuffix(".txt"));
		
		
		for( String f : directory){
			System.out.println(f);
			
		}
		
	}

}
