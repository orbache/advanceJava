package q2;

/**
* This class is a checking account with minimum balance and no monthly commission
* @author Evyatar Orbach
*/
public class NoServiceChargeChecking extends CheckingAccount{
	
	private static final double MINIMUM_BALANCE = 10;
	private double minimumBalance = MINIMUM_BALANCE;
	
	public NoServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public NoServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance);
		if(minimumBalance >= 0) {
			this.minimumBalance = minimumBalance;
		}
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		if(minimumBalance >= 0) {
			this.minimumBalance = minimumBalance;
		}
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
				" Minimum balance: "+this.minimumBalance;
	}
	
	/**
	* {@inheritDoc}
	* @param otherNoServiceChargeChecking other bank account to compare
	*/
	@Override
	public boolean equals(BankAccount otherNoServiceChargeChecking) {
		try {
			if(this.getNumberAccount().equals(otherNoServiceChargeChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherNoServiceChargeChecking.getOwnerAccount()) && 
				this.getId().equals(otherNoServiceChargeChecking.getId()) && 
				this.getBalance() == otherNoServiceChargeChecking.getBalance() && 
				this.minimumBalance == ((NoServiceChargeChecking)otherNoServiceChargeChecking).getMinimumBalance()){
					return true;
			}
		}catch (Exception e) {
			System.out.println("Can't compare 2 difference types of banks accounts");
			return false;
		}
		return false;
	}

	@Override
	public void monthlyManagement() throws IllegalBalance {
		
	}

}
