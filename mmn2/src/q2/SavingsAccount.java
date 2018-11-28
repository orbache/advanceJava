package q2;

/**
* This class is a BankAccount with interest
* @author Evyatar Orbach
*/
public class SavingsAccount extends BankAccount{

	private static final double INTEREST = 0.25;
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

	/**
	* {@inheritDoc}
	*/
	@Override
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
				" Interest: "+this.interest;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public boolean equals(BankAccount otherSavingsAccount) {
		try{
			if(this.getNumberAccount().equals(otherSavingsAccount.getNumberAccount()) && 
				this.getOwnerAccount().equals(otherSavingsAccount.getOwnerAccount()) && 
				this.getId().equals(otherSavingsAccount.getId()) && 
				this.getBalance() == otherSavingsAccount.getBalance() && 
				this.interest == ((SavingsAccount)otherSavingsAccount).getInterest()){
					return true;
			}
		}catch (Exception e) {
			System.out.println("Can't compare 2 difference types of banks accounts");
			return false;
		}
		return false;
	}
}
