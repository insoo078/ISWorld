
public class Particles extends Thread{
	public static final int CARBON = 1;
	public static final int NITROGEN = 2;
	public static final int NEON = 3;
	public static final int MAGNETIUM = 4;
	public static final int SILICON = 5;
	public static final int IRON = 6;
	public static final int SULPHUR = 7;
	public static final int ARGON = 8;
	public static final int ALMINUM = 9;
	public static final int OXYGEN = 10;
	public static final int ETC = 99;
	
	private int type;
	private double x;
	private double y;
	private double z;
	private double temporature;
	private double radius;
	private double speed_sec;
	
	private volatile boolean stop;

	public Particles(int type, double x, double y, double z) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;
		this.temporature = -999999;
		this.radius = 0.00001;
		this.speed_sec = Math.random() * 1000;
		this.stop = false;
		
		this.start();
	}

	public boolean isCollision(Particles particle) {
		double radiusSum = this.radius + particle.getRadius();
		
		double diffX = (this.x - particle.getX());
		double diffY = (this.y - particle.getY());
		double diffZ = (this.z - particle.getZ());
		
		double distanceBetweenCenters = Math.sqrt( diffX*diffX + diffY*diffY + diffZ*diffZ );
		
		if( distanceBetweenCenters <= radiusSum )	return true;

		return false;
	}
	
	public void done() {
		this.stop = true;
	}
	
	@Override
	public void run() {
		while(!this.stop) {
			try {
				Thread.sleep( (long)this.speed_sec );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getTemporature() {
		return temporature;
	}
	public void setTemporature(double temporature) {
		this.temporature = temporature;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
