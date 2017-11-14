package IO;
public class Date{
	private int year;
	private int month;
	private int day;
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;

	}
	//��ʾ��ǰ����
	public void display(){
		System.out.println(month + "/" + day
		    + "/" + year);
	    }
	//���㵱ǰ���ڵ���һ��
	public Date nextDay(){
		int aday=day+1;
		int amonth=month;
		int ayear=year;
		if (aday>maxDay()){
			aday=1;
			amonth++;

			if(amonth>=12){
			  amonth=1;	
			  ayear++;	
			}
		}
        
		return new Date(ayear,amonth,aday);
	}
	//���㵱ǰ����������
	public void afterDay(){
		
	}
	//�жϵ�ǰ���ڵ��·ݵ��������
	public int maxDay(){
		int m=30;
		switch(month){
		    case 1:
		    case 3:
		    case 5:
		    case 7:
		    case 8:
		    case 10:
		    case 12: m=31;break;
		    case 2:
		    if(isLeapYear()){
			return	m=29;
		    }else{
		        return	m=28;
		    }
		    default :m=30;break;
		    }
		return m;
		    
		}
	//�жϵ�ǰ���ڵ�����Ƿ�Ϊ����
	public boolean isLeapYear(){
		if((year%4==0&&year%100!=0)||(year%400==0))
		{
		  return true;
		}else{
		return false;
		}
	}	
}
