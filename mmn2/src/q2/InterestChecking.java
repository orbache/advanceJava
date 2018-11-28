package q2;

/**
* This class is a NoServiceChargeChecking with interest and minimum balance (higher than in NoServiceChargeChecking) and no monthly commission
* @author Evyatar Orbach
*/
public class InterestChecking extends NoServiceChargeChecking{

	private static final double INTEREST = 0.15;
	private static final double HIGHER_MINIMUM_BALANCE = 20;
	private double interest = INTEREST;
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance,HIGHER_MINIMUM_BALANCE);
	}
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance,minimumBalance);
	}
	
	public InterestChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance, double interest) {
		super(numberAccount, ownerAccount, id, balance,minimumBalance);
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	/**
	* {@inheritDoc}
	*/
	public void monthlyManagement() {
		double newBalance = this.getBalance() * (1 + this.interest);
		this.setBalance(newBalance);
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public String toString() {
		return "Number account: "+this.getNumberAccount()+
				" Owner Account: "+this.getOwnerAccount()+
				" Id: "+this.getId()+
				" Balance: "+String.format("%.2f", this.getBalance())+
				" Minimum balance: "+this.getMinimumBalance()+
				" Interest: "+this.interest;
	}
	
	/**
	* {@inheritDoc}
	* * @param otherInterestChecking other bank account to compare
	*/
	@Override
	public boolean equals(BankAccount otherInterestChecking) {
		try {
			if(this.getNumberAccount().equals(otherInterestChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherInterestChecking.getOwnerAccount()) && 
				this.getId().equals(otherInterestChecking.getId()) && 
				this.getBalance() == otherInterestChecking.getBalance() && 
				this.getMinimumBalance() == ((InterestChecking)otherInterestChecking).getMinimumBalance() &&
				this.interest == ((InterestChecking)otherInterestChecking).getInterest()){
					return true;
			}
		}catch (Exception e) {
			System.out.println("Can't compare 2 difference types of banks accounts");
			return false;
		}
		return false;
	}

	
}
