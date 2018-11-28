package q2;

/**
* This class extends Exception that is a form that indicates conditions that a reasonable
 * application might want to catch.
* @author Evyatar Orbach
*/
public class IllegalBalance extends Exception{
	
	/**
     * Constructs a new exception with the specified detail message.
     * @param   message   the detail message.
     */
	public IllegalBalance(String message) {
		super(message);
	}
}
