package Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;


public class SerialCloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee Kevin = new Employee("Kevin", 3500, 2016, 12, 31);
		Employee kevin2 = (Employee) Kevin.clone();
		Kevin.raiseSalary(10);
		System.out.println(Kevin);
		System.out.println(kevin2);
		
	}
}

class SerialCloneable implements Cloneable,Serializable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(this);
			os.close();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bais);
			Object readObject = oi.readObject();
			oi.close();
			
			return readObject;
			
		} catch (Exception e) {
			return null;
		}
	}
}


class Employee extends SerialCloneable{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String name, double salary, int year,int month,int day) {
		this.name = name;
		this.salary = salary;
		this.hireDay = new GregorianCalendar(year,month-1,day).getTime();
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	
	
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	@Override
	public String toString() {
		return getClass().getName()+"{name="+name+",salary="+salary+",hireDay="+hireDay+"}";
	}
	
	
	
	
	
	
	
	
	
}

