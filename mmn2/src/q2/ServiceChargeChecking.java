package q2;

public class ServiceChargeChecking extends CheckingAccount{

	private static final double MONTHLY_COMMISSION = 10;
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
	
	@Override
	public void monthlyManagement() {
		double newBalance = this.getBalance() - this.commission;
		this.setBalance(newBalance);
	}
	
	@Override
	public String toString() {
		return "Number account: "+this.getNumberAccount()+
				" Owner Account: "+this.getOwnerAccount()+
				" Id: "+this.getId()+
				" Balance: "+this.getBalance()+
				" Commission: "+this.commission;
	}
	
	public boolean equals(ServiceChargeChecking otherServiceChargeChecking) {
		if(this.getNumberAccount().equals(otherServiceChargeChecking.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherServiceChargeChecking.getOwnerAccount()) && 
				this.getId().equals(otherServiceChargeChecking.getId()) && 
				this.getBalance() == otherServiceChargeChecking.getBalance() && 
				this.commission == otherServiceChargeChecking.getCommission()){
			return true;
		}
		return false;
	}
}
