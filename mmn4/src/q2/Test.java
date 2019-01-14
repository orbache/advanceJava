/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;

import java.io.FileNotFoundException;

/**
 * this class starting the test with the file handler
 * @author eorbach
 *
 */
public class Test {
	static FileHandler fileHandler;
	
	public static void main(String[] args) {
		fileHandler = new FileHandler("src/q2/tmp.txt");
		Dictionary dictionary = new Dictionary();
		
		try {
			fileHandler.readFromFile(dictionary);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		Menu window = new Menu(dictionary);
	}
}
