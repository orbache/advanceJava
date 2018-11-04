package q2;

public class Term implements Comparable<Term> {
	private double coefficient;
	private int power;

	//Constructors
	Term(double coefficient, int power) {
		this.coefficient = coefficient;
		this.power = power;
	}
	
	Term(Term term) {
		this.coefficient = term.coefficient;
		this.power = term.power;
	}

	//Methods
	public Term plus(Term otherTerm){
		Term newTerm;
		double newCoefficient = this.coefficient + otherTerm.coefficient;
		if(newCoefficient != 0) {
			newTerm = new Term(newCoefficient,this.power);
		}else {
			newTerm = new Term(0,0);
		}
		return newTerm;
	}
	
	public Term minus(Term otherTerm){
		Term newTerm;
		double newCoefficient = this.coefficient - otherTerm.coefficient;
		if(newCoefficient != 0) {
			newTerm = new Term(newCoefficient,this.power);
		}else {
			newTerm = new Term(0,0);
		}
		return newTerm;
	}
	
	/*The below function compare the powers and the coefficients between 2 terms
	 * in case the powers are different then we checked whether the 
	 * term with the bigger power have a positive/negative coefficient
	 * if the powers are equal then we compare the coefficients*/
	@Override
	public int compareTo(Term t1) {
		int diff = 0;
		
        if(t1.power < this.power) {
        	if(this.coefficient > 0) {
        		diff = 1;
        	}else {
        		diff = -1;
        	}
        	
        }
        else if (t1.power > this.power) {
        	if(t1.coefficient > 0) {
        		diff = -1;
        	}else {
        		diff = 1;
        	}
			
		}
        else if (t1.power == this.power){
        	if(t1.coefficient < this.coefficient) {
        		diff = 1;
        	}
        	 else if (t1.coefficient > this.coefficient) {
        		 diff = -1;
     			
     		}
        }
        return diff;
	}
	
	/*The below function compare only the powers between 2 terms*/
	public int powerCompare(Term t1) {
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

	public double getCoefficient() {
		return coefficient;
	}

	public int getPower() {
		return power;
	}
}
