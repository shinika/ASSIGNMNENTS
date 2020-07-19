package asign.montran.pojo;

public class Time {
	private int hr;
	private int min;
	void settime(int hr, int min){
		this.hr=hr;
		this.min=min;
	}
	void showtime(){
		System.out.println(+hr);
		System.out.println(+min);
	}
	time  sum(time) {
		time=hr+min;
		return time;
	}

	@Override
	public String toString() {
		return "Time [hr=" + hr + ", min=" + min + "]";
	}
}
	
