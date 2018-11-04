package q1;

public class PaymentLine {
	private int amount;
	private double total;
	private String productName;
	
	public PaymentLine(Item item, int amount) {
		this.amount = amount;
		this.total = amount * item.getPrice();
		this.productName = item.getProductName();
	}

	public int getAmount() {
		return amount;
	}

	public double getTotal() {
		return total;
	}

	public String getProductName() {
		return productName;
	}
	
	
}
