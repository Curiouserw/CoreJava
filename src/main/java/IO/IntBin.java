package IO;

public class IntBin {
	private int value;

	public IntBin(int value) {
		this.value = value;
	}
	//��ָ��λ�õĶ���������Ϊ1
	public IntBin bitSet(int position){
		int a=value|(1<<position);
		return new IntBin(a);
	}
	
	//��ָ��λ�õĶ���������Ϊ0
	public IntBin bitZero(int position){
		
		int b=~(1<<position )&value;
		return new IntBin(b);
	}
	//��ָ��λ�õĶ�������ȡ��
    public IntBin bitReverse(int position){
    	int c=value^(1<<position);
    	return new IntBin(c);
	}
    //��ʮ�������Զ���������ʽ���
		public void disPlay(){
		    int[] array = new int[32];
			int n=31;
			for(int i=0;i<31;i++)
			{
				array[n]=(this.value>>i)&1;
				n--;
			}
			for(int d : array){
				System.out.print(d);
			}
			System.out.println();
		}
		
	}
	

