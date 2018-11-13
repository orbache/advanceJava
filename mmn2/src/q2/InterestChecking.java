package q2;

public class InterestChecking extends NoServiceChargeChecking{

	private static final double INTEREST = 0.2;
	private static final double ADDON_MINIMUM_BALANCE = 5;
	private double interest = INTEREST;
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance);
		this.setMinimumBalance(minimumBalance + ADDON_MINIMUM_BALANCE);
	}
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance, double interest) {
		super(numberAccount, ownerAccount, id, balance);
		this.setMinimumBalance(minimumBalance + ADDON_MINIMUM_BALANCE);
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
				" Minimum balance: "+this.getMinimumBalance()+
				" Interest: "+this.interest;
	}
	
	public boolean equals(InterestChecking otherInterestChecking) {
		if(this.getNumberAccount().equals(otherInterestChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherInterestChecking.getOwnerAccount()) && 
				this.getId().equals(otherInterestChecking.getId()) && 
				this.getBalance() == otherInterestChecking.getBalance() && 
				this.getMinimumBalance() == otherInterestChecking.getMinimumBalance() &&
				this.interest == otherInterestChecking.getInterest()){
			return true;
		}
		return false;
	}

	
}
