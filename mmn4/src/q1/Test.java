/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu1
 */
package q1;

public class Test {
	static final String[] foo = {"a","b","c","d","e","f"};
	
	public static void main(String[] arg) throws EmptyListException {
		int index;
		LinkedList<String> strs = new LinkedList<String>(); 
		strs.add("g");
		strs.add("h");
		strs.add("i:");
		for(index=0;index<foo.length;index++) {
			strs.add(foo[index]);
		}
		System.out.println(strs);
		
		LinkedList<String> srts = new LinkedList<String>();
		System.out.println(strs.reverseList(srts));
		
		LinkedList<Person> persons = new LinkedList<Person>(); 
		persons.add(new Person("a", "1", 1988));
		persons.add(new Person("b", "2", 2000));
		persons.add(new Person("c", "3", 1954));
		persons.add(new Person("d", "4", 2018));
		
		System.out.println(persons); //print the list of the persons
		System.out.println(Test.max(persons).getCellContent()); //print the older person
		
	}
	
	/**
	 * this function return the max cell define by the comparable function implements in the class
	 * static because it got all the parameter it need
	 * @param list
	 * @return Cell
	 */
	public static <E extends Comparable<E>> Cell<E> max(LinkedList<E> list) {
		Cell<E> head = list.getHead();
		Cell<E> biggest = head;
	
		while(head != list.getTail()) {
			if(biggest.getCellContent().compareTo(head.getNextCell().getCellContent()) < 0) {
				biggest = head.getNextCell();
			}
			head = head.getNextCell();
		}
		return biggest;
	}
}
