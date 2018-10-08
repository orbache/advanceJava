package q2;

public class Term implements Comparable<Term> {
	public int coefficient;
	public int power;
	Term(int coefficient, int power) {
		this.coefficient = coefficient;
		this.power = power;
	}

	@Override
	public int compareTo(Term t1) {
        return t1.power - this.power;
	}
}
