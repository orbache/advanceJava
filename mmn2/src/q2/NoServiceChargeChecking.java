package q2;

public class NoServiceChargeChecking extends CheckingAccount{
	
	private static final double MINIMUM_BALANCE = 5;
	private double minimumBalance = MINIMUM_BALANCE;
	
	public NoServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public NoServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance, double minimumBalance) {
		super(numberAccount, ownerAccount, id, balance);
		this.minimumBalance = minimumBalance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		if(minimumBalance >= 0) {
			this.minimumBalance = minimumBalance;
		}
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
	public void monthlyManagement() {}
	
	@Override
	public String toString() {
		return "Number account: "+this.getNumberAccount()+
				" Owner Account: "+this.getOwnerAccount()+
				" Id: "+this.getId()+
				" Balance: "+this.getBalance()+
				" Minimum balance: "+this.minimumBalance;
	}
	
	public boolean equals(NoServiceChargeChecking otherNoServiceChargeChecking) {
		if(this.getNumberAccount().equals(otherNoServiceChargeChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherNoServiceChargeChecking.getOwnerAccount()) && 
				this.getId().equals(otherNoServiceChargeChecking.getId()) && 
				this.getBalance() == otherNoServiceChargeChecking.getBalance() && 
				this.minimumBalance == otherNoServiceChargeChecking.getMinimumBalance()){
			return true;
		}
		return false;
	}

}
