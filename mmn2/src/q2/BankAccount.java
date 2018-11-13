package q2;

public abstract class BankAccount{
	private String numberAccount;
	private String ownerAccount;
	private String id;
	private double balance;
	
	public BankAccount(String numberAccount,String ownerAccount,String id,double balance) {
		this.numberAccount = numberAccount;
		this.ownerAccount = ownerAccount;
		this.id = id;
		this.balance = balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double money) {
		if(money > 0) {
			this.balance += money;
		}
	}
	
	public void pull(double money) throws IllegalBalance {
		if(money > balance) {
			throw new IllegalBalance("Not enough money to pull");
		}else{
			this.balance -= money;
		}
	}
	
	public abstract void monthlyManagement();
	
	@Override
	public String toString() {
		return "Number account: "+this.numberAccount+" Owner Account: "+this.ownerAccount+" Id: "+this.id+" Balance: "+this.balance;
	}
	
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
