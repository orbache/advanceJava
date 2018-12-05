package q2;

/**
* Abstract class of Checking Account
* @author Evyatar Orbach
*/
public abstract class CheckingAccount extends BankAccount{
	
	public CheckingAccount(String numberAccount,String ownerAccount,String id,double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	/**
	* This function allow to write a check
	* @param money	how much money to write in the check
	* @throws IllegalBalance if trying to write more money than in balance
	*/
	public void writeCheck(double money) throws IllegalBalance{
		this.pull(money);
	}
}
