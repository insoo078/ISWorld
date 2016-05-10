import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Universe> objList = new ArrayList<Universe>();
		
		Universe universe1 = new Universe("Universe 1");
//		Universe universe2 = new Universe("Universe 2");
		universe1.bigbang();

		while(true) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println(">");
			String keyword = keyboard.nextLine();
			
			if( keyword.toUpperCase().equals("TIME") ) {
				System.out.println( universe1.getTimeStamp() );
			}else if(keyword.toUpperCase().equals("Q") || keyword.toUpperCase().equals("QUIT") ) {
				universe1.destroy();

				break;
			}else if( keyword.toUpperCase().equals("C") || keyword.toUpperCase().equals("CREATE") ) {
				Universe universe1 = new Universe("Universe 1");
			}
		}
	}
}
