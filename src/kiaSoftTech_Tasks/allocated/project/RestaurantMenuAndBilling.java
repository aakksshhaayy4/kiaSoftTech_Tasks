package kiaSoftTech_Tasks.allocated.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantMenuAndBilling {

	public static Map<Integer, MenuItem> menu = new HashMap<>();
	public static Scanner scanner = new Scanner(System.in);
	public static List<MenuItem> orderItem = new ArrayList<>();

	public static void main(String[] args) {
		generateMenu();
		showMenu();

		int choice;
		do {
			choice = getMenuChoice();
			switch (choice) {
			case 1:
				placeOrder();
				break;
			case 2:
				generateBill();
				break;
			case 3:
				System.out.println("Thank you for visiting the restaurant!");
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
				break;
			}
		} while (choice != 3);

		scanner.close();
	}

	public static void generateMenu() {
		menu.put(1, new MenuItem(250, "Pizza"));
		menu.put(2, new MenuItem(175, "Burger"));
		menu.put(3, new MenuItem(25, "Vada Paav"));
		menu.put(4, new MenuItem(50, "Manchurian"));
		menu.put(5, new MenuItem(40, "Noodles"));
	}

	public static void generateBill() {
		if (orderItem.isEmpty()) {
			System.out.println("No Items Available  in the Order. Please first Order an Items");
			return;
		}
		System.out.println("Your Order:");
		System.out.println("*************************************");
		double totalAmount = 0;

		for (MenuItem item : orderItem) {
			System.out.println(item.getName() + " - ₹ " + item.getPrice());
			totalAmount += item.getPrice();
		}

		System.out.println("*************************************");
		System.out.println("Total Amount: ₹ " + totalAmount);
		System.out.println("*************************************");

		// Clear the order items for the next order
		orderItem.clear();
	}

	public static void showMenu() {
		System.out.println("Restaurant Menu Card");
		System.out.println("------------------------------------------------------------");
		System.out.println("Menu : ");
		for (Map.Entry<Integer, MenuItem> menuEntry : menu.entrySet()) {
			Integer itemNumber = menuEntry.getKey();
			MenuItem item = menuEntry.getValue();
			System.out.println(itemNumber + ". " + item.getName() + " - ₹ " + item.getPrice());
		}
		System.out.println("------------------------------------------------------------");
	}

	public static void placeOrder() {
		System.out.println("Please Enter the Number to Order the Item : ");
		int itemId = scanner.nextInt();
		if (menu.containsKey(itemId)) {
			orderItem.add(menu.get(itemId));
			System.out.println("Item added to your Order");
		} else {
			System.out.println("Invalid Item Number ! Please pass valid Item Number !");
		}
	}

	public static int getMenuChoice() {
		System.out.println("Press Below For Your Choice : ");
		System.out.println("1. Place Order");
		System.out.println("2. Generate Bill");
		System.out.println("3. Exits");
		System.out.println("Enter Your Choice");
		return scanner.nextInt();
	}

}
