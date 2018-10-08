package q1;

public class PaymentLine {
	int amount;
	double total;
	String productName;
	
	public PaymentLine(Item item, int amount) {
		this.amount = amount;
		this.total = amount * item.price;
		this.productName = item.productName;
	}
}
