package IO;

import IO.Date;

public class DateTest {

	public static void main(String[] args) {
		Date currentDate=new Date(2016,2,28);
		currentDate.display();
		currentDate.nextDay().display();

	}

}
