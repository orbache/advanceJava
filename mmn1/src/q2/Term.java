package q2;

public class Term implements Comparable<Term> {
	public double coefficient;
	public int power;

	Term(double coefficient, int power) {
		this.coefficient = coefficient;
		this.power = power;
	}

	@Override
	public int compareTo(Term t1) {
        if(t1.power < this.power) {
        	return 1;
        }
        else if (t1.power > this.power) {
        	return -1;
			
		}
        else {
			return 0;
		}
	}
}
