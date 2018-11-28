/**
 *Create: Evyatar Orbach
 *ID: 301740015
 *Date: 6/11/2018
 *Title: MMN 2 - Advanced Java programming 
 */

package q2;

public class Test{

	public static void main(String[] args) {
		BankAccount[] accounts = {
				new ServiceChargeChecking("0001", "a", "1", 0),
				new ServiceChargeChecking("1001", "b", "2", 0, 2),
				new NoServiceChargeChecking("0002", "c", "3", 0),
				new NoServiceChargeChecking("1002", "d", "4", 0, 7),
				new InterestChecking("0003", "e", "5", 0),
				new InterestChecking("1003", "f", "6", 0, 5),
				new InterestChecking("2003", "g", "7", 0, 6, 0.44),
				new SavingsAccount("0004", "h", "8", 0),
				new SavingsAccount("1004", "i", "9", 0, 0.22),
				new HighInterestSavings("0005", "j", "10", 0),
				new HighInterestSavings("1005", "k", "11", 0, 0.66),
				new HighInterestSavings("2005", "l", "12", 0, 0.88, 5)
		};
		
		System.out.println("Beginning status");
		for(int i=0;i<accounts.length;i++) {
			System.out.println(accounts[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Deposit of 200 to all accounts");
		for(int i=0;i<accounts.length;i++) {
			accounts[i].deposit(200);
			System.out.println(accounts[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Pull 190 from all accounts");
		for(int i=0;i<accounts.length;i++) {
			try {
				accounts[i].pull(190);
			} catch (IllegalBalance e) {
				System.out.println(e.getMessage());
			}
			System.out.println(accounts[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Write check to all the Checking accounts (pull 15)");
		for(int i=0;i<7;i++) {
			try {
				((CheckingAccount)accounts[i]).writeCheck(15);
			} catch (IllegalBalance e) {
				System.out.println(e.getMessage());
			}
			System.out.println(accounts[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Operate monthly management");
		for(int i=0;i<accounts.length;i++) {
			try {
				accounts[i].monthlyManagement();
			}catch (IllegalBalance e) {
				System.out.println(e.getMessage());
			}
			System.out.println(accounts[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Checking some equals of accounts types");
		System.out.println(accounts[0].equals(accounts[3]));//false
		System.out.println(accounts[4].equals(accounts[11]));//false
		System.out.println(accounts[8].equals(accounts[9]));//false
		
		System.out.println(accounts[0]);
		InterestChecking foo = new InterestChecking("0001", "a", "1", 2);
		InterestChecking moo = new InterestChecking("0001", "a", "1", 2);
		System.out.println(foo);
		System.out.println(foo.equals(accounts[0]));//false
		System.out.println(foo.equals(moo));//true
		System.out.println();
		System.out.println();
	}
}
