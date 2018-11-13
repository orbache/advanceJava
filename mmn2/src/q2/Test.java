package q2;

public class Test{

	public static void main(String[] args) {
		BankAccount[] accounts = {
				new ServiceChargeChecking("0001", "a", "1", 0),
				new ServiceChargeChecking("1001", "b", "2", 0, 2),
				new NoServiceChargeChecking("0002", "c", "3", 10),
				new NoServiceChargeChecking("1002", "d", "4", 0, 5),
				new InterestChecking("0003", "e", "5", 10),
				new InterestChecking("1003", "f", "6", 0, 5),
				new InterestChecking("2003", "g", "7", 0, 6, 0.15),
				new SavingsAccount("0004", "h", "8", 10),
				new SavingsAccount("1004", "i", "9", 0, 0.15),
				new HighInterestSavings("0005", "j", "10", 10),
				new HighInterestSavings("1005", "k", "11", 0, 0.15),
				new HighInterestSavings("2005", "l", "12", 0, 0.15, 5)
		};	
		
		System.out.println(accounts[0]);
	}
}
