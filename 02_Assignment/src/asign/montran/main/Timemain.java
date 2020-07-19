package asign.montran.main;

import asign.montran.pojo.*;

public class Timemain {

	public static void main(String[] args) {
		Time time=new Time();

		time.settime(06,30);
		time.showtime();

		System.out.println(+time.showtime());
		
/*
		time sum(time);
		return time;
*/
		System.out.println(time);

	}

}
