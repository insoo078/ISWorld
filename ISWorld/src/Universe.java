
public class Universe {
	private String name;
	private Clock clock;
	
	private Long size;
	private float accerlate;
	
	public Universe(String name) {
		this.name = name;
		this.clock = new Clock();
		this.size = 0l;
		this.accerlate = 0.01f;
	}
	
	public void bigbang() {
		Thread thread = new Thread( this.clock );
		thread.start();
	}
	
	public void destroy() {
		this.clock.done();
	}
	
	public String getTimeStamp() {
		return this.clock.getTimeStamp();
	}
}