package q1;

import java.util.Scanner;

public class Test {
	
	//Items list
	static Item[] itemsList = {new Item("bamba",3.5),new Item("chips",4),new Item("bisley",2.3)};
	
	public static void main(String [] args) {
		
		//variables
		CashDesk cashDesk = new CashDesk();
		Scanner input = new Scanner(System.in);
		int choise,itemNumber;
		int amount;
		int index;
		double payment;
		
		do {
			menu();
			System.out.println("Please enter your choise: (for exit please enter 0)");
			choise = input.nextInt();
			switch(choise) {
			//Exit
			case 0:
				System.out.println("Thank you! bye bye");
				break;
			//Add an item to the bill
			case 1:
				showItemsList();
				break;
			//Buy an item
			case 2:
				showItemsList();
				System.out.println("Please enter your choise: ");
				itemNumber = input.nextInt();
				System.out.println("Please enter the amount: ");
				amount = input.nextInt();
				cashDesk.buyItem(itemsList[itemNumber-1], amount);
				break;
			//Get bill
			case 3:
				for(index=0;index<cashDesk.getBill().size();++index) {
					System.out.printf("%-20s",cashDesk.getBill().get(index).getAmount());
					System.out.printf("%-25s",cashDesk.getBill().get(index).getProductName());
					System.out.printf("%s\n",cashDesk.getBill().get(index).getTotal());
				}
				break;
			//Get total of bill
			case 4:
				System.out.printf("%.2f\n\n",cashDesk.getTotal());
				break;
			//Payment
			case 5:
				System.out.printf("You need to pay: %.2f\n",cashDesk.getTotal());
				System.out.println("Please enter the amount to pay: ");
				payment = input.nextDouble();
				System.out.printf("Your change is: %.2f\n\n",cashDesk.pay(payment));
				break;
			case 6:
				System.out.printf("The total money in the cash desk: %.2f\n\n",cashDesk.getCashTotal());
				break;
			default:
				System.out.println("Error - you chose illegal number. Please try again");
			}
		}while(choise != 0);
	input.close();
	}//main()
	
	public static void showItemsList() {
		int number = 1;
		System.out.println("List of products and prices");
		for(Item item: itemsList) {
			System.out.printf("%2s: %-10s - %-5s\n",number,item.getProductName(),item.getPrice());	
			++number;
		}
		System.out.println();
	}
	public static void menu() {
		System.out.println("\t+++++\tMenu\t+++++\n");
		System.out.printf("\t%-27s%5s\n","Watch items list and prices","1" );
		System.out.printf("\t%-27s%5s\n","Buy an item","2" );
		System.out.printf("\t%-27s%5s\n","Get bill","3" );
		System.out.printf("\t%-27s%5s\n","Get total of bill","4" );
		System.out.printf("\t%-27s%5s\n","Pay for bill","5" );
		System.out.printf("\t%-27s%5s\n","Get total of the cash desk","6" );
		System.out.println();
	}//menu()
}//q1

