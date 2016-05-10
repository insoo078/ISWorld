
public class DynamicObject implements Runnable{
	public static int RUNNING = 1;
	public static int DONE = 0;
	public static int KILLED = 2;
	public static int HOLD = 3;
	public static int READY = 4;

	private String objName;
	private int status;
	
	public DynamicObject(String name, int status) {
		this.objName = name;
		this.status = status;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println( this.objName + " is " + this.status );
	}
}
