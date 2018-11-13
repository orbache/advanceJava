package q2;

public abstract class CheckingAccount extends BankAccount{
	
	public CheckingAccount(String numberAccount,String ownerAccount,String id,double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public void writeCheck(double money) throws IllegalBalance {
		try {
			this.pull(money);
		}catch (IllegalBalance exception) {
			throw exception;
		}
	}
}
