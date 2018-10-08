package q1;
import java.util.ArrayList;

public class CashDesk {
	//variables
	private double cashTotal = 0;
	private double total;
	private ArrayList<PaymentLine> bill = new ArrayList<PaymentLine>(0);
	public ArrayList<Item> itemsList = new ArrayList<Item>(0);
	
	//constructors
	CashDesk(){
		this.cashTotal = 0;
	}
	CashDesk(double cashStartAmount){
		this.cashTotal = cashStartAmount;
	}	
	
	//methods
	/*create new Item*/
	public void createItem(String productName, double price) {
		itemsList.add(new Item(productName, price));
	}
	/*buy an Item and add it to the bill*/
	public void buyItem(Item item, int amount) {
		bill.add(new PaymentLine(item, amount));
	}
	/*get current customer bill*/
	public ArrayList<PaymentLine> getCustomerBill() {
		return bill;
	}
	/*get the total of current bill*/
	public double getTotal() {
		total = 0;
		for (int index=0; index < bill.size();index++) {
			total += bill.get(index).total; 
		}
		return total;
	}
	/*pay and got the change*/
	public double pay(double payment) {
		//Assume the payment is always more than total
		double change = payment - getTotal();
		this.cashTotal += getTotal();
		bill.clear();
		return change;
	}
	/*get the total of current cash desk*/
	public double getTotalCashDesk() {
		return cashTotal;
	}
}
