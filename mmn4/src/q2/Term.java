/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;

/**
 * this class implement term in a dictionary
 * @author eorbach
 *
 */
public class Term implements Comparable<Term>{
	private String key;
	private String value;
	
	/**
	 * constructor of term
	 * @param key - word
	 * @param value - the meaning or translation of the key word
	 */
	public Term(String key,String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * empty term constructor
	 */
	public Term() {
		// TODO Auto-generated constructor stub
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * compare between keys
	 */
	public int compareTo(Term term) {
		return this.key.compareTo(term.getKey());
	};
	
	public String toString() {
		return this.key+" : "+this.value;
		
	}
}
