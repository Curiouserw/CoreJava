package Enum;

public class EnumertionDemo {
	enum e {A,B,C}
	
	public static void main(String[] args) {
		for(e i : e.values()) {
			System.out.println(i);
		}
		System.out.println("=========");
//		System.out.println(e.valueOf(arg0));
	}
}
