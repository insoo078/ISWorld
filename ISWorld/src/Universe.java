import java.util.List;
import java.util.Map;
import java.util.Random;

public class Universe implements Runnable{
	private String name;
	private Clock clock;

	private Double radius;
	private float accerlate;

	private volatile boolean stop;

	Map< String, List<Particles> > particles;

	public Universe(String name) {
		this.name = name;
		this.clock = new Clock();
		this.accerlate = 0.01f;
		this.stop = false;
		this.accerlate = 0;
	}
	
//	public static final int CARBON = 1;			0.033
//	public static final int NITROGEN = 2;		0.010
//	public static final int NEON = 3;			0.0098
//	public static final int MAGNETIUM = 4;		0.0033
//	public static final int SILICON = 5;		0.0033
//	public static final int IRON = 6;			0.0029
//	public static final int SULPHUR = 7;		0.0015
//	public static final int ARGON = 8;			0.00033
//	public static final int ALMINUM = 9;		0.00027
//	public static final int OXYGEN = 10;		0.0078
//	public static final int ETC = 99;			0.00072
	
	private Map<String, List<Particles>> getParticlesMap() {
//		List<Particles> 
		long n = (long)(1000000000 + (Math.random() * 100000000));

		return null;
	}

	public void bigbang() {		
		Thread thread2 = new Thread( this );
		thread2.start();

		this.radius = Math.random() * this.getBigBangEnergy();
	}

	private double getBigBangEnergy() {
		Random rand = new Random();

		return (Math.abs(rand.nextGaussian()) / 1000) * (Math.random() * 43312);
	}

	public void destroy() {
		this.clock.done();
		this.stop = true;
	}

	public String getTimeStampWithStatus() {
		return this.clock.getTimeStamp() + " " + this.radius;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread clockThread = new Thread( this.clock );
		clockThread.start();

		int currentYear = 0;
		while( !stop ) {
			if( currentYear != this.clock.getYear() && (this.clock.getYear() % 100) == 0.0 ) {
				this.radius += (1 * (1+this.accerlate));
				currentYear = this.clock.getYear();
				
				this.accerlate += 1;
				
				System.out.println( this.name + " Univer. : " + this.getTimeStampWithStatus() );
			}
		}
	}
}