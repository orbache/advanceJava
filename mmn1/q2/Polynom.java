package q2;

import java.util.ArrayList;

public class Polynom implements Comparable<Polynom> {
	private ArrayList<Term> terms = new ArrayList<Term>();
	
	//Constructors
	Polynom(double[] coefficients,int[] powers) {
		for(int index = 0; index < coefficients.length;++index) {
			if(coefficients[index] != 0) {
				this.terms.add(new Term(coefficients[index], powers[index]));	
			}
		}
		this.sortPolynomByPower();
	}
	
	Polynom() {
	}
	
	//Methods
	public void sortPolynomByPower() {
		if(this.terms.size()>1) {
			reverseQuickSort(0, this.terms.size()-1);
		}
	}
		
    private void swapTerms(int i, int j) {
        Term temp = this.terms.get(i);
        this.terms.set(i, this.terms.get(j));
        this.terms.set(j, temp);
    }
   
    private void reverseQuickSort(int firstIndex, int lastIndex) {
       int i = firstIndex;
       int j = lastIndex;
       Term pivot = this.terms.get((lastIndex-firstIndex)/2+firstIndex);
       while (i <= j) {
           while (this.terms.get(i).powerCompare(pivot) == 1) {
               i++;
           }
           while (this.terms.get(j).powerCompare(pivot) == -1) {
               j--;
           }
           if (i <= j) {
           	swapTerms(i, j);
               i++;
               j--;
           }
       }
       if (firstIndex < j)
    	   reverseQuickSort(firstIndex, j);
       if (i < lastIndex)
    	   reverseQuickSort(i, lastIndex);
   }
	
	public Polynom plus(Polynom polynom) {
		int thisIndex=0;
		int otherIndex=0;
		Term thisTerm,otherTerm;
		Polynom newPolynom = new Polynom();
		while(thisIndex < this.terms.size() && otherIndex < polynom.terms.size()) {
			thisTerm = this.terms.get(thisIndex);
			otherTerm = polynom.terms.get(otherIndex);
			if(thisTerm.powerCompare(otherTerm) == -1) {
				newPolynom.terms.add(new Term(otherTerm));
				otherIndex++;
			}
			else if(thisTerm.powerCompare(otherTerm) == 1) {
				newPolynom.terms.add(new Term(thisTerm));
				thisIndex++;
			}
			else {
				newPolynom.terms.add(thisTerm.plus(otherTerm));
				thisIndex++;
				otherIndex++;
			}
		}
		if(thisIndex == this.terms.size() && otherIndex < polynom.terms.size()) {
			while(otherIndex < polynom.terms.size()) {
				newPolynom.terms.add(new Term(polynom.terms.get(otherIndex)));
				++otherIndex;
			}
		}
		else if(thisIndex < this.terms.size() && otherIndex == polynom.terms.size()) {
			while(thisIndex < this.terms.size()) {
				newPolynom.terms.add(new Term(this.terms.get(thisIndex)));
				++thisIndex;
			}
		}		
		return newPolynom;
	}
	
	public Polynom minus(Polynom polynom) {
		int thisIndex=0;
		int otherIndex=0;
		Term thisTerm,otherTerm;
		Polynom newPolynom = new Polynom();
		while(thisIndex < this.terms.size() && otherIndex < polynom.terms.size()) {
			thisTerm = this.terms.get(thisIndex);
			otherTerm = polynom.terms.get(otherIndex);
			if(thisTerm.powerCompare(otherTerm) == -1) {
				newPolynom.terms.add(new Term(otherTerm.getCoefficient()*-1,otherTerm.getPower()));
				otherIndex++;
			}
			else if(thisTerm.powerCompare(otherTerm) == 1) {
				newPolynom.terms.add(new Term(thisTerm));
				thisIndex++;
			}
			else {
				newPolynom.terms.add(thisTerm.minus(otherTerm));
				thisIndex++;
				otherIndex++;
			}
		}
		if(thisIndex == this.terms.size() && otherIndex < polynom.terms.size()) {
			while(otherIndex < polynom.terms.size()) {
				newPolynom.terms.add(new Term(polynom.terms.get(otherIndex).getCoefficient()*-1,polynom.terms.get(otherIndex).getPower()));
				++otherIndex;
			}
		}
		else if(thisIndex < this.terms.size() && otherIndex == polynom.terms.size()) {
			while(thisIndex < this.terms.size()) {
				newPolynom.terms.add(new Term(this.terms.get(thisIndex)));
				++thisIndex;
			}
		}		
		return newPolynom;
	}

	public Polynom derivation() {
		int newPower;
		double newCoefficient;
		Polynom newPolynom = new Polynom();
		for(int index=0; index < this.terms.size(); ++index) {
			newPower = this.terms.get(index).getPower()-1;
			newCoefficient = this.terms.get(index).getCoefficient()*this.terms.get(index).getPower();
			newPolynom.terms.add(new Term(newCoefficient,newPower));
			if(newPolynom.terms.get(index).getCoefficient() == 0) {
				newPolynom.terms.remove(index);
			}
		}
		return newPolynom;
	}

	@Override
	public String toString() {
		String str="";
		for(Term term : this.terms) {
			if(term.getCoefficient() != 0) {
				if(term.getCoefficient() > 0) {
					if(term.getCoefficient() == 1) {
						if(term.getPower() == 0) {
							str += "+" + term.getCoefficient();
						}else {
							str += "+";
						}
					}else {
						str += "+" + term.getCoefficient();
					}
				}else if(term.getCoefficient() < 0) {
					if(term.getCoefficient() == -1) {
						if(term.getPower() == 0) {
							str += term.getCoefficient();
						}else {
							str += "-";
						}
					}else {
						str += term.getCoefficient();
					}
				}
			}
			if(term.getPower() != 0) {
				if(term.getPower() == 1) {
					str += "X";
				}else {
					str += "X^" + term.getPower();
				}
			}
		}
		if(str.isEmpty()) {
			str = "0";
		}else if(str.charAt(0) == '+') {
			return str.substring(1);
		}
		return str;
	}

	@Override
	public int compareTo(Polynom polinom) {
		int shortestPolynomSize = 0,diff = 0,index;
		Term thisTerm;
		Term otherTerm;
		shortestPolynomSize = this.terms.size() > polinom.terms.size() ? polinom.terms.size() : this.terms.size();
		for(index = 0; index < shortestPolynomSize; ++index) {
			thisTerm = this.terms.get(index);
			otherTerm = polinom.terms.get(index);
			diff = thisTerm.compareTo(otherTerm);
			if(diff != 0) {
				return diff;
			}
		}
		if(shortestPolynomSize < this.terms.size()) {
			return 1;
		}
		else if(shortestPolynomSize < polinom.terms.size()) {
			return -1;
		}
		return 0;
	}
}
