package q2;

public class HighInterestSavings extends SavingsAccount{

	private static final double ADDON_INTEREST = 0.15;
	private static final double MINIMUM_BALANCE = 3;
	private double minimumBalance = MINIMUM_BALANCE;
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance, double interest) {
		super(numberAccount, ownerAccount, id, balance);
		this.setInterest(interest + ADDON_INTEREST);
	}
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance, double interest, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance);
		this.minimumBalance = minimumBalance;
		this.setInterest(interest + ADDON_INTEREST);
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	@Override
	public void pull(double money) throws IllegalBalance {
		double newBalance = getBalance() - money;
		if(newBalance < this.getMinimumBalance()) {
			throw new IllegalBalance("Not enough money to pull");
		}else{
			this.setBalance(newBalance);
		}
	}
	
	@Override
	public String toString() {
		return "Number account: "+this.getNumberAccount()+
				" Owner Account: "+this.getOwnerAccount()+
				" Id: "+this.getId()+
				" Balance: "+this.getBalance()+
				" Minimum balance: "+this.minimumBalance+
				" Interet: "+this.getInterest();
	}
	
	public boolean equals(HighInterestSavings otherHighInterestSavings) {
		if(this.getNumberAccount().equals(otherHighInterestSavings.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherHighInterestSavings.getOwnerAccount()) && 
				this.getId().equals(otherHighInterestSavings.getId()) && 
				this.getBalance() == otherHighInterestSavings.getBalance() && 
				this.minimumBalance == otherHighInterestSavings.getMinimumBalance() &&
				this.getInterest() == otherHighInterestSavings.getInterest()){
			return true;
		}
		return false;
	}

}
