/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu2
 */
package q2;

import java.util.TreeSet;
/**
 * this class implement dictionary
 * @author eorbach
 *
 */
public class Dictionary {
	private TreeSet<Term> dict;

	public Dictionary() {
		dict = new TreeSet<Term>();
	}
	
	public TreeSet<Term> getDict() {
		return dict;
	}
	
	public void add(Term term) {
		dict.add(term);
	}
	
	public void remove(String key) {
		for (Term term : dict) {
			if(term.getKey() == key) {
				dict.remove(term);
				break;
			}
		}
	}
	
	/**
	 * update the value of exist key
	 * @param key
	 * @param value - new value
	 */
	public void update(String key, String value) {
		for (Term term : dict) {
			if(term.getKey() == key) {
				term.setValue(value);
				break;
			}
		}
	}
	
	public String toString() {
		String st = "";
		for (Term term : dict) {
			st += term.toString() + "\n";
		}
		return st;
	}
}
