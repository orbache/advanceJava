package q2;
import java.util.Scanner;

public class Test {
	static public final int AMOUNT_OF_POLYNOMIALS = 2;
	
	public static void main(String [] args) {
		Polynom[] polynom = new Polynom[AMOUNT_OF_POLYNOMIALS];
		double [][] coeff = new double[AMOUNT_OF_POLYNOMIALS][];
		int [][] pow = new int[AMOUNT_OF_POLYNOMIALS][];
		int index,numOfPolynomials,polynomialsSize =0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter size for polynomials: ");
		polynomialsSize = input.nextInt();
		for(numOfPolynomials = 0;numOfPolynomials<AMOUNT_OF_POLYNOMIALS;numOfPolynomials++) {
			coeff[numOfPolynomials] = new double[polynomialsSize];
			pow[numOfPolynomials] = new int[polynomialsSize];
			System.out.printf("Please enter %dth polynomials coefficients and powers\n",numOfPolynomials+1);
			for(index=0;index<polynomialsSize;++index) {
				coeff[numOfPolynomials][index] = input.nextDouble();
				pow[numOfPolynomials][index] = input.nextInt();
			}
			polynom[numOfPolynomials] = new Polynom(coeff[numOfPolynomials],pow[numOfPolynomials]);
		}
		input.close();
		
		System.out.printf("1th Polynom is: %s\n",polynom[0].toString());
		System.out.printf("2th Polynom is: %s\n",polynom[1].toString());
		System.out.printf("Polynom 1 PLUS polynom 2 is: %s\n",polynom[0].plus(polynom[1]).toString());
		System.out.printf("Polynom 1 MINUS polynom 2 is: %s\n",polynom[0].minus(polynom[1]).toString());
		System.out.printf("Polynom 1 derivation is: %s\n",polynom[0].derivation().toString());
		System.out.printf("Polynom 2 derivation is: %s\n",polynom[1].derivation().toString());
	}
}//Test
