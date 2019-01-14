/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * this class handling files
 * @author eorbach
 *
 */
public class FileHandler {
	private File file;
	
	public FileHandler(String fileName) {
		this.file = new File(fileName);
	}
	
	/**
	 * fill the dictionary with the file content
	 * @param dictionary
	 * @throws FileNotFoundException - if there is no file to read from
	 */
	public void readFromFile(Dictionary dictionary) throws FileNotFoundException {	
		Scanner input = new Scanner(this.file);
		while(input.hasNext()) {
			dictionary.add(new Term(input.nextLine(), input.nextLine()));
		}
		input.close();
	}
	
	/**
	 * write the updated dictionary to a file
	 * @param dictionary
	 * @throws FileNotFoundException - if there is no file to write to
	 */
	public void writeToFile(Dictionary dictionary) throws FileNotFoundException {
		Formatter output = new Formatter(this.file);
		for(Term term:dictionary.getDict()) {
			output.format("%s\n", term.getKey());
			output.format("%s\n", term.getValue());
		}
		output.close();
	}
	
}
