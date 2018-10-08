package q2;

public class q2 {

	public static void main(String [] args) {
		int [] coff = {3,-5,4,2};
		int [] pow = {1,8,0,4};
		Polynom polynom = new Polynom(coff,pow);
		polynom.PrintPolynom();
	}
}
