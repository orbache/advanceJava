package q2;

import java.util.ArrayList;
import java.util.Collections;


public class Polynom {
	int index,iteration;
	ArrayList<Term> terms = new ArrayList<Term>();
	
	//Constructors
	public Polynom(int[] coefficients,int[] powers) {
		for(index = 0; index < coefficients.length;++index) {
			this.terms.add(new Term(coefficients[index], powers[index]));
		}
		Collections.sort(terms);
	}
	
	//Methods
	public Polynom plus(Polynom polynom) {
		index = 0;
		iteration = 0;
		for(Term term1 : terms) {
			for(Term term2 : polynom.terms) {
				if(term2.power == term1.power) {
					term2.coefficient += term1.coefficient;
					polynom.terms.set(index,term2);
					break;
					}
				else if (term2.power < term1.power) {
					polynom.terms.add(index,term1);
				}
				index++;
			}
		}
		return polynom;
	}
	
	
	public void PrintPolynom() {
		for(Term term : terms) {
			System.out.printf("%d^%d ", term.coefficient,term.power);
		}
	}
	
	/*@Override
	public int compareTo(Polynom p1) {
        return p1.terms - this.terms;
	}*/
}
