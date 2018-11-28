package q2;

/**
* Abstract class of Bank Account
* @author Evyatar Orbach
*/
public abstract class BankAccount{
	private String numberAccount;
	private String ownerAccount;
	private String id;
	private double balance;
	
	public BankAccount(String numberAccount,String ownerAccount,String id,double balance) {
		this.numberAccount = numberAccount;
		this.ownerAccount = ownerAccount;
		this.id = id;
		if(balance >= 0) {
			this.balance = balance;
		}else {
			this.balance = 0; 
		}
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public String getId() {
		return id;
	}
	
	/**
	* This function deposit money to the bank account and add it to the balance
	* @param money	how much money to deposit
	*/
	public void deposit(double money) {
		if(money > 0) {
			this.balance += money;
		}
	}
	
	/**
	* This function pull money from the bank account and subtract it from the balance
	* @param money	how much money to pull
	* @throws IllegalBalance if trying to pull more money than in balance
	*/
	public void pull(double money) throws IllegalBalance {
		if(money > balance) {
			throw new IllegalBalance("Not enough money to pull");
		}else{
			this.balance -= money;
		}
	}
	
	/**
	* Abstract function will monthly manipulate the balance
	*/
	public abstract void monthlyManagement() throws IllegalBalance;
	
	/**
	* This function override the toString function in Object class
	* @return String of all the current variables of the object
	*/
	@Override
	public String toString() {
		return "Number account: "+this.numberAccount+" "
				+ "Owner Account: "+this.ownerAccount+" "
				+ "Id: "+this.id+" Balance: "+String.format("%.2f", this.balance);
	}
	
	/**
	* This function compare between bank accounts
	* @param otherBankAccount other bank account to compare
	* @return true if all the parameters are equals, otherwise return false
	*/
	public boolean equals(BankAccount otherBankAccount) {
		if(this.numberAccount.equals(otherBankAccount.numberAccount) && 
			this.ownerAccount.equals(otherBankAccount.ownerAccount) && 
			this.id.equals(otherBankAccount.id) && 
			this.balance == otherBankAccount.balance) {
				return true;
			}
		return false;
	}
}
