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
	/*Connect terms assuming power are equals*/
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
	
	/*Subtract terms assuming power are equals*/
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
	
	@Override
	public int compareTo(Term t1) {
        if(t1.power < this.power) {
        	return 1;
        }
        else if (t1.power > this.power) {
        	return -1;
			
		}
        else {
        	if(t1.coefficient < this.coefficient) {
        		return 1;
        	}
        	 else if (t1.coefficient > this.coefficient) {
             	return -1;
     			
     		}
			return 0;
		}
	}
	
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
