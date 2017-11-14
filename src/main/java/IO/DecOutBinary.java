package IO;



/**
 * @author RM
 *��һ��ʮ���������Զ����Ƶ���ʽ���
 */
public class DecOutBinary {
	private int value;

	public DecOutBinary(int value) {
		super();
		this.value = value;
	}
	
	//����1��ʹ�����
//	public void OutBin1(){
//		System.out.println(Integer.toBinaryString(value));
//	}
	
	//����2��ѭ����ģȡ��
//	public void OutBin2(){	
//		int[] a = new int[32];
//		for(int i=31;value!=0;i--){
//			a[i]=value%2;
//			value=value/2;	
//		}
		
//	}
	//����3����λ��1���С��롰����
	public void  OutBin3(){
	    int[] array= new int[32];
		int n=31;
		for(int i=0;i<31;i++)
		{
			array[n]=(value>>i)&1;
			n--;
		}
		for(int d : array){
			System.out.print(d);
		}
	}
	
	
}
