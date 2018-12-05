package q2;

/**
* This class is a checking account that in addition collect a monthly commission
* @author Evyatar Orbach
*/
public class ServiceChargeChecking extends CheckingAccount{

	private static final double MONTHLY_COMMISSION = 8;
	private double commission = MONTHLY_COMMISSION;
	
	public ServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance) {
		super(numberAccount, ownerAccount, id, balance);
	}
	
	public ServiceChargeChecking(String numberAccount, String ownerAccount, String id, double balance, double commission) {
		super(numberAccount, ownerAccount, id, balance);
		this.commission = commission;
	}
	
	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	/**
	* {@inheritDoc}
	*/
	public void monthlyManagement() throws IllegalBalance{
		double newBalance = this.getBalance() - this.commission;
		if(newBalance < 0) {
			throw new IllegalBalance("There is not enough money in balance, can't charge commission");
		}else {
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
				" Commission: "+this.commission;
	}
	
	/**
	* {@inheritDoc}
	* @param otherServiceChargeChecking other bank account to compare
	*/
	@Override
	public boolean equals(BankAccount otherServiceChargeChecking) {
		if(otherServiceChargeChecking == null || !(otherServiceChargeChecking instanceof ServiceChargeChecking)) {
			return false;
		}else {
			return (this.getNumberAccount().equals(otherServiceChargeChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherServiceChargeChecking.getOwnerAccount()) && 
				this.getId().equals(otherServiceChargeChecking.getId()) && 
				this.getBalance() == otherServiceChargeChecking.getBalance() && 
				this.commission == ((ServiceChargeChecking)otherServiceChargeChecking).getCommission());
		}
	}
}
