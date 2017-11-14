package IO;

import java.io.File;
import java.io.FilenameFilter;
//�ӿڣ�FilenameFilter ʵ�ִ˽ӿڵ���ʵ�������ڹ����ļ��� ֻ��һ������accept
public class FilterByContain implements FilenameFilter {
	private String content;
	public FilterByContain(String content) {
		super();
		this.content = content;
	}

	public boolean accept(File dir, String name) {

		return name.contains(content);
	}

}
