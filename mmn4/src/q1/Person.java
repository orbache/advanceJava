/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu1
 */
package q1;

/**
 * This class implemet a person
 * @author eorbach
 *
 */
public class Person implements Comparable<Person>{
	private String name;
	private String id;
	private int birthYear;
	
	/**
	 * Constructor of person
	 * @param name - the name of the person
	 * @param id - the person's id
	 * @param birthYear - the year of birth
	 */
	public Person(String name, String id, int birthYear) {
		this.name = name;
		this.id = id;
		this.birthYear = birthYear;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public String toString() {
		return name+" "+id+" "+birthYear;
	}
	
	/**
	 * Override the compareTo to allow comparing between persons by their ages
	 */
	@Override
	public int compareTo(Person otherPerson) {
		if(this.birthYear < otherPerson.birthYear) {
			return 1;
		}else if(this.birthYear > otherPerson.getBirthYear()) {
			return -1;
		}
		return 0;
	}
}
