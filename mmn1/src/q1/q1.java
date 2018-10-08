package q1;

import java.util.Scanner;

public class q1 {
	public static void main(String [] args) {
		CashDesk cashDesk = new CashDesk();
		Scanner input = new Scanner(System.in);
		int choise,amount,index;
		double price,pay;
		String productName;
		do {
			menu();
			System.out.println("Please enter your choise: (for exit please enter 0)");
			choise = input.nextInt();
			switch(choise) {
			case 0:
				System.out.println("Thank you! bye bye");
				break;
			case 1:
				System.out.println("Name of product: ");
				productName = input.next();
				System.out.println("Price of product: ");
				price = input.nextDouble();
				cashDesk.createItem(productName, price);
				break;
			case 2:
				for(index=0;index<cashDesk.itemsList.size();++index) {
					System.out.printf("%-20s%3s\n",cashDesk.itemsList.get(index).productName,cashDesk.itemsList.get(index).price);
				}
				break;
			case 3:
				System.out.println("Please enter the item you want to buy: ");
				productName = input.next();
				System.out.println("Please enter the amount: ");
				amount = input.nextInt();
				for(index=0;index<cashDesk.itemsList.size();++index) {
					if(cashDesk.itemsList.get(index).productName.equals(productName)){
						cashDesk.buyItem(cashDesk.itemsList.get(index), amount);
						break;
					}
				}
				break;
			case 4:
				for(index=0;index<cashDesk.getCustomerBill().size();++index) {
					System.out.printf("%-20s",cashDesk.getCustomerBill().get(index).amount);
					System.out.printf("%-25s",cashDesk.getCustomerBill().get(index).productName);
					System.out.printf("%s\n",cashDesk.getCustomerBill().get(index).total);
				}
				break;
			case 5:
				System.out.printf("%f\n\n",cashDesk.getTotal());
				break;
			case 6:
				System.out.println("Please enter the amount to pay: ");
				pay = input.nextDouble();
				System.out.printf("Your change is: %f\n\n",cashDesk.pay(pay));
				break;
			case 7:
				System.out.printf("The total money in the cash desk: %f\n\n",cashDesk.getTotalCashDesk());
				break;
			default:
				System.out.println("Error - you chose illegal number. Please choose again");
			}
		}while(choise != 0);
	}
	
	private static void menu() {
		System.out.println("\t+++++\tMenu\t+++++\n");
		System.out.printf("\t%-26s%5s\n","Create new item","1" );
		System.out.printf("\t%-26s%5s\n","Show all items","2" );
		System.out.printf("\t%-26s%5s\n","Buy an Item","3" );
		System.out.printf("\t%-26s%5s\n","Get bill","4" );
		System.out.printf("\t%-26s%5s\n","Get total of bill","5" );
		System.out.printf("\t%-26s%5s\n","Pay for bill","6" );
		System.out.printf("\t%s%5s\n","Get total of the cash desk","7" );
		System.out.println();
	}
}

