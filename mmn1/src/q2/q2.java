package q2;
import java.util.Scanner;

public class q2 {

	public static void main(String [] args) {
		final int AMOUNT_OF_POLYNOMIALS = 2;
		double [][] coeff = new double[AMOUNT_OF_POLYNOMIALS][];
		int [][] pow = new int[AMOUNT_OF_POLYNOMIALS][];
		int index,numOfPolynomials,degree =0;
		Polynom[] polynom = new Polynom[AMOUNT_OF_POLYNOMIALS];
		
		Scanner input = new Scanner(System.in);
		for(numOfPolynomials = 0;numOfPolynomials<AMOUNT_OF_POLYNOMIALS;numOfPolynomials++) {
			System.out.printf("Please enter degree of %dth polynomials\n",numOfPolynomials+1);
			degree = input.nextInt();
			coeff[numOfPolynomials] = new double[degree];
			pow[numOfPolynomials] = new int[degree];
			System.out.printf("Please enter %dth polynomials coefficients\n",numOfPolynomials+1);
			for(index=0;index<degree;++index) {
				coeff[numOfPolynomials][index] = input.nextDouble();
			}
			System.out.printf("Please enter %dth polynomials powers\n",numOfPolynomials+1);
			for(index=0;index<degree;++index) {
				pow[numOfPolynomials][index] = input.nextInt();
			}
			polynom[numOfPolynomials] = new Polynom(coeff[numOfPolynomials],pow[numOfPolynomials]);
		}
		input.close();
		
		
		System.out.printf("1th Polynom is: %s\n",polynom[0].toString());
		System.out.printf("2th Polynom is: %s\n",polynom[1].toString());
		
		System.out.printf("Polynom 1 PLUS polynom 2 is: %s\n",polynom[0].plus(polynom[1]).toString());
		System.out.printf("Polynom 1 MINUS polynom 2 is: %s\n",polynom[0].minus(polynom[1]).toString());
		polynom[0].derivation();
		System.out.printf("Derivation of polynom 1 is: %s\n",polynom[0].toString());
		polynom[1].derivation();
		System.out.printf("Derivation of polynom 2 is: %s\n",polynom[1].toString());
	}
}
