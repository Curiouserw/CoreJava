package IO;

import java.io.File;
import java.io.FilenameFilter;


public class FilterBySuffix implements FilenameFilter {
	private String suffix;
	public FilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}

	
	//accept���������б��е�String nameָ���Ǳ�����Ŀ¼�е��ļ��л����ļ�������
	public boolean accept(File dir, String name) {

		return name.endsWith(suffix);
	}

}
