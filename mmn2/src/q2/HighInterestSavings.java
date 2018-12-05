package q2;

/**
* This class is a SavingsAccount with interest (higher than in SavingsAccount) and minimum balance
* @author Evyatar Orbach
*/
public class HighInterestSavings extends SavingsAccount{

	private static final double HIGHER_INTEREST = 0.35;
	private static final double MINIMUM_BALANCE = 12;
	private double minimumBalance = MINIMUM_BALANCE;
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance, HIGHER_INTEREST);
	}
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance, double interest) {
		super(numberAccount, ownerAccount, id, balance, interest);
	}
	
	public HighInterestSavings(String numberAccount, String ownerAccount, String id, double balance, double interest, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance, interest);
		this.minimumBalance = minimumBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public void pull(double money) throws IllegalBalance {
		double newBalance = getBalance() - money;
		if(newBalance < this.getMinimumBalance()) {
			throw new IllegalBalance("Not enough money to pull");
		}else{
			this.setBalance(newBalance);
		}
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
				" Minimum balance: "+this.minimumBalance+
				" Interest: "+this.getInterest();
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean equals(BankAccount otherHighInterestSavings) {
		if(otherHighInterestSavings == null || !(otherHighInterestSavings instanceof HighInterestSavings)) {
			return false;
		}else {
			return (this.getNumberAccount().equals(otherHighInterestSavings.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherHighInterestSavings.getOwnerAccount()) && 
				this.getId().equals(otherHighInterestSavings.getId()) && 
				this.getBalance() == otherHighInterestSavings.getBalance() && 
				this.minimumBalance == ((HighInterestSavings)otherHighInterestSavings).getMinimumBalance() &&
				this.getInterest() == ((HighInterestSavings)otherHighInterestSavings).getInterest());
		}
	}

}
