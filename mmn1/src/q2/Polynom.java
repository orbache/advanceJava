package q2;

import java.util.ArrayList;
import java.util.Collections;

public class Polynom implements Comparable<Polynom> {
	ArrayList<Term> terms = new ArrayList<Term>();
	
	//Constructors
	public Polynom(double[] coefficients,int[] powers) {
		for(int index = 0; index < coefficients.length;++index) {
			this.terms.add(new Term(coefficients[index], powers[index]));
		}
		Collections.sort(this.terms, Collections.reverseOrder());
	}
	
	//Methods
	
	public Polynom plus(Polynom polynom) {
		int index = 0;
		double coefficient;
		int power;
		double[] a={0};
		int[] b={0};
		Term otherTerm;
		Polynom newPolynom = new Polynom(a,b);
		for(Term thisTerm : this.terms) {
			while(index < polynom.terms.size()) {
				otherTerm = polynom.terms.get(index);
				if(otherTerm.power == thisTerm.power) {
					coefficient = thisTerm.coefficient + otherTerm.coefficient;
					power = thisTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					index++;
					break;
				}
				else if (thisTerm.power > otherTerm.power) {
					coefficient = thisTerm.coefficient;
					power = thisTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					if(polynom.terms.indexOf(otherTerm) > this.terms.size()) {
						newPolynom.terms.add(otherTerm);
					}
					break;
				}
				else {
					coefficient = otherTerm.coefficient;
					power = otherTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					index++;
					if(polynom.terms.size() == index) {
						newPolynom.terms.add(thisTerm);
					}
				}
			}
		}
		newPolynom.terms.remove(0);
		return newPolynom;
	}
	
	public Polynom minus(Polynom polynom) {
		int index = 0;
		double coefficient;
		int power;
		double[] a={0};
		int[] b={0};
		Term otherTerm;
		Polynom newPolynom = new Polynom(a,b);
		for(Term thisTerm : this.terms) {
			while(index < polynom.terms.size()) {
				otherTerm = polynom.terms.get(index);
				if(otherTerm.power == thisTerm.power) {
					coefficient = thisTerm.coefficient - otherTerm.coefficient;
					power = thisTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					index++;
					break;
				}
				else if (thisTerm.power > otherTerm.power) {
					coefficient = thisTerm.coefficient;
					power = thisTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					if(polynom.terms.indexOf(otherTerm) > this.terms.size()) {
						newPolynom.terms.add(otherTerm);
					}
					break;
				}
				else {
					coefficient = -1*otherTerm.coefficient;
					power = otherTerm.power;
					newPolynom.terms.add(new Term(coefficient,power));
					index++;
					if(polynom.terms.size() == index) {
						newPolynom.terms.add(thisTerm);
					}
				}
			}
		}
		newPolynom.terms.remove(0);
		return newPolynom;
	}

	public void derivation() {
		for(int index=0; index < this.terms.size(); ++index) {
			this.terms.get(index).coefficient *= this.terms.get(index).power;
			this.terms.get(index).power -= 1;
			if(this.terms.get(index).coefficient == 0) {
				this.terms.remove(index);
			}
		}
	}

	@Override
	public String toString() {
		String str="";
		for(Term term : this.terms) {
			if(term.coefficient != 0) {
				if(term.coefficient > 0) {
					str += "+" + term.coefficient + "X^" + term.power;
					continue;
				}
				str += term.coefficient + "X^" + term.power;
			}
		}
		str = str.replace("X^1-", "X-");
		str = str.replace("X^1+", "X+");
		str = str.replace("X^0", "");
		str = str.replace("+1.0X", "+X");
		str = str.replace("-1.0X", "-X");
		if(str.startsWith("+")) {
			str = str.substring(1);
		}
		
		return str;
	}

	@Override
	public int compareTo(Polynom polinom) {
		int shortestPolynom = 0,index;
		Term thisTerm;
		Term otherTerm;
		shortestPolynom = this.terms.size() > polinom.terms.size() ? polinom.terms.size() : this.terms.size();
		for(index = 0; index < shortestPolynom; ++index) {
			thisTerm = this.terms.get(index);
			otherTerm = polinom.terms.get(index);
			if(thisTerm.compareTo(otherTerm) == 0) {
				continue;
			}else {
				return thisTerm.compareTo(otherTerm);
			}
		}
		return 0;
	}
	
	
	
	
	
//public Polynom minus(Polynom polynom) {
//	int index = -1;
//	Term term2;
//	for(Term term1 : this.terms) {
//		while(index < polynom.terms.size()) {
//			index++;
//			term2 = polynom.terms.get(index);
//			if(term1.power == term2.power) {
//				term1.coefficient -= term2.coefficient;
//				polynom.terms.set(index,term1);
//				if(term2.coefficient == 0) {
//					polynom.terms.remove(term2);
//				}
//				break;
//			}
//			else if (term1.power > term2.power) {
//				polynom.terms.add(index,term1);
//				break;
//			}
//			else {
//				term2.coefficient *= -1;
//				polynom.terms.set(index,term2);
//				if (index+1 == polynom.terms.size()) {
//					polynom.terms.add(term1);
//					break;
//				}
//			}
//		}
//	}
//	return polynom;
//}
//
//public Polynom plus(Polynom polynom) {
//int index = 0;
//Term term2;
//for(Term term1 : this.terms) {
//	while(index < polynom.terms.size()) {
//		term2 = polynom.terms.get(index);
//		if(term2.power == term1.power) {
//			term2.coefficient += term1.coefficient;
//			polynom.terms.set(index,term2);
//			if(term2.coefficient == 0) {
//				polynom.terms.remove(term2);
//			}
//			break;
//		}
//		else if (term2.power < term1.power) {
//			polynom.terms.add(index,term1);
//			break;
//		}
//		else if (index+1 == polynom.terms.size()) {
//			polynom.terms.add(term1);
//			break;
//		}
//		index++;
//	}
//}
//return polynom;
//}


}//class Polynom
