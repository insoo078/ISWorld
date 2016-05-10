import java.time.Month;

public class Clock implements Runnable{
	private double accelerate;

	private int hour;
	private int minuate;
	private int sec;
	private int day;
	private int month;
	private int year;
	
	private volatile boolean stop;
	
	public Clock() {
		this.accelerate = 1;
		this.hour = 0;
		this.minuate = 0;
		this.sec = 0;
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.stop = false;
	}
	
	public int getYear() {
		return this.year;
	}

	public String getTimeStamp() {
		

		return this.year + "yr " + Month.of(this.month).name() + " " + this.day + " " + this.hour + "hh " + this.minuate + "mm " + this.sec + "ss";
	}
	
	public void done() {
		this.stop = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while( !this.stop ) {
			this.sec++;
			if( this.sec == 60 ) {
				this.minuate++;
				this.sec = 0;
			}
			if( this.minuate == 60 ) {
				this.hour++;
				this.minuate = 0;
			}
			if( this.hour == 24 ) {
				this.hour = 0;
				this.day++;
			}
			if( this.day == 31 ) {
				this.month++;
				this.day = 1;
			}
			if( this.month == 12 ) {
				this.year++;
				this.month = 1;
			}
		}
	}
}
