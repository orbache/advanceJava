package q1;
import java.util.ArrayList;

public class CashDesk {
	//variables
	private double cashTotal;
	private double total;
	private ArrayList<PaymentLine> bill = new ArrayList<PaymentLine>(0);
	
	//constructors
	CashDesk(){
		this.cashTotal = 0;
	}
	
	CashDesk(double cashStartAmount){
		this.cashTotal = cashStartAmount;
	}	
	
	//methods
	/*buy an item and add it to the bill*/
	public void buyItem(Item item, int amount) {
		double price = item.getPrice() * amount;
		bill.add(new PaymentLine(item, amount));
		total += price;
	}
	
	/*pay and got the change*/
	public double pay(double payment) {
		//Assume the payment is always >= to total
		double change = payment - getTotal();
		this.cashTotal += getTotal();
		this.bill.clear();
		this.total = 0;
		return change;
	}
	
	/*get the total of current bill*/
	public double getTotal() {
		return total;
	}
	
	public double getCashTotal() {
		return cashTotal;
	}
	
	public ArrayList<PaymentLine> getBill() {
		return bill;
	}
	
}
