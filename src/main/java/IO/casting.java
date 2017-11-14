package IO;

public class casting {

	public static void main(String[] args) {
		short a=-5;
		
		int x,y,b=6,c=7;
		byte d=5;
		System.out.println(b++);
		System.out.println(++b);
		System.out.println(c++);
		System.out.println(++c);
		x=b++ +c++;
		y=(++b)+(++c);
		System.out.println(x);
		System.out.println("y="+y);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(Integer.toBinaryString(a));
	}

}
