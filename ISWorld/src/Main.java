import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Map<String, Universe> universeMap = new HashMap<String, Universe>();

		Runtime runtime = Runtime.getRuntime();
		System.out.println("Available processors : " + runtime.availableProcessors() );

		String universeName = "test1";
		Universe universe = new Universe( universeName );
		universeMap.put(universeName, universe);
		universe.bigbang();

		String choosedName = universeName;
		while(true) {
			Scanner keyboard = new Scanner(System.in);
			System.out.print(">");
			String keyword = keyboard.nextLine();

			if( keyword.toUpperCase().equals("TIME") ) {
				System.out.println( universeMap.get(choosedName ).getTimeStampWithStatus() );
			}else if(keyword.toUpperCase().equals("Q") || keyword.toUpperCase().equals("QUIT") ) {
				universeMap.get(choosedName).destroy();

				break;
//			}else if( keyword.toUpperCase().equals("C") || keyword.toUpperCase().equals("CREATE") ) {
//				Scanner universeNameScanner = new Scanner(System.in);
//				System.out.print("Universe name > ");
//				String universeName = universeNameScanner.nextLine();
//
//				Universe universe = new Universe( universeName );
//				universeMap.put(universeName, universe);
//				universe.bigbang();
			}
		}
	}
}