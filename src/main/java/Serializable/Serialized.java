package Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person {
	private String name;
	private int age;
	
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person :" + name + ", age=" + age + "]";
	}
	
}

class Man extends Person implements Serializable{
	private String gender;
	
	public Man(String name, int age) {
		super(name, age);
		this.gender="男";
	}
	@Override
	public String toString() {
		return "Man [gender=" + gender + ", toString()=" + super.toString() + "]";
	}
	
}



public class Serialized {
	static FileOutputStream fos=null;
	static ObjectOutputStream os=null;
	public static void writeObject(Person p,String path) {
		
		try {
			fos=new FileOutputStream(new File(path));
			os=new ObjectOutputStream(fos);
			os.writeObject(p);
			fos.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	public static Person readObject(String path) {
		Person person=null;
		try {
			FileInputStream fileInputStream=new FileInputStream(new File(path));
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			person=(Person) objectInputStream.readObject();
			fileInputStream.close();
			objectInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return person;
	}
	
	public static void main(String[] args) throws IOException {
//		Person p1=new Person("zhangsan",15);
//		
//		writeObject(p1);
//		
//		System.out.println(readObject("/home/rm/Desktop/Person"));
		
		Man man=new Man("lisi", 20);
		writeObject(man,"/home/rm/Desktop/man");
		System.out.println(readObject("/home/rm/Desktop/man"));
		
		
		
	}
}
