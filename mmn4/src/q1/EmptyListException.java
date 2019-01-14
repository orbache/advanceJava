/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu1
 */
package q1;

/**
 * new exception class for empty list declared
 * @author eorbach
 *
 */
public class EmptyListException extends Exception{
	public EmptyListException() {
		System.out.println("The list is empty");
	}
}
