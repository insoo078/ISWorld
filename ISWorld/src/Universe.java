import java.util.ArrayList;
import java.util.HashMap;
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
//	public static final int OXYGEN = 10;		0.078
//	public static final int ETC = 99;			0.00072
	
	private static Map<String, List<Particles>> getParticlesMap() { 
		long n = (long)(100000 + (Math.random() * 10000));

		Map<String, List<Particles>> particleMap = new HashMap<String, List<Particles>>();
		particleMap.put("CARBON",		Universe.getTypeParticles( Particles.CARBON,	(int)(n * 0.33) ) );
		particleMap.put("NITROGEN",		Universe.getTypeParticles( Particles.NITROGEN,	(int)(n * 0.10) ) );
		particleMap.put("NEON", 		Universe.getTypeParticles( Particles.NEON,		(int)(n * 0.098) ) );
		particleMap.put("MAGNETIUM",	Universe.getTypeParticles( Particles.MAGNETIUM,	(int)(n * 0.033) ) );
		particleMap.put("SILICON",		Universe.getTypeParticles( Particles.SILICON,	(int)(n * 0.033) ) );
		particleMap.put("IRON",			Universe.getTypeParticles( Particles.IRON,		(int)(n * 0.029) ) );
		particleMap.put("SULPHUR",		Universe.getTypeParticles( Particles.SULPHUR,	(int)(n * 0.015) ) );
		particleMap.put("ARGON",		Universe.getTypeParticles( Particles.ARGON,		(int)(n * 0.0033) ) );
		particleMap.put("ALMINUM",		Universe.getTypeParticles( Particles.ALMINUM,	(int)(n * 0.0027) ) );
		particleMap.put("OXYGEN",		Universe.getTypeParticles( Particles.OXYGEN,	(int)(n * 0.78) ) );
		particleMap.put("ETC",			Universe.getTypeParticles( Particles.ETC,		(int)(n * 0.0072) ) );
		
		return particleMap;
	}
	
	private static List<Particles> getTypeParticles( int type, int n ) {
		List<Particles> list = new ArrayList<Particles>();
		for(int i=0; i<n; i++) {
			Particles particle = new Particles(type, 0, 0, 0);
			list.add( particle );
		}
		return list;
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
		
		Map<String, List<Particles>> map = this.getParticlesMap();

		System.out.println( map.size() );

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