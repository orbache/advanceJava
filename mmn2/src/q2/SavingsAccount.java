package q2;

public class SavingsAccount extends BankAccount{

	private static final double INTEREST = 0.3;
	private double interest = INTEREST;
	
	public SavingsAccount(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public SavingsAccount(String numberAccount, String ownerAccount, String id, double balance, double interest) {
		super(numberAccount, ownerAccount, id, balance);
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public void monthlyManagement() {
		double newBalance = this.getBalance() * (1 + this.interest);
		this.setBalance(newBalance);	
	}
	
	@Override
	public String toString() {
		return "Number account: "+this.getNumberAccount()+
				" Owner Account: "+this.getOwnerAccount()+
				" Id: "+this.getId()+
				" Balance: "+this.getBalance()+
				" Interet: "+this.interest;
	}
	
	public boolean equals(SavingsAccount otherSavingsAccount) {
		if(this.getNumberAccount().equals(otherSavingsAccount.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherSavingsAccount.getOwnerAccount()) && 
				this.getId().equals(otherSavingsAccount.getId()) && 
				this.getBalance() == otherSavingsAccount.getBalance() && 
				this.interest == otherSavingsAccount.getInterest()){
			return true;
		}
		return false;
	}
}
