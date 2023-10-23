package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String Email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		String birth = sc.next();
		System.out.println("Enter order data:");
		
		Client client = new Client(name, Email, birth);
		
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		
		Order order = new Order(OrderStatus.valueOf(status), LocalDateTime.now(), client);
		
		System.out.print("How many items to this order? ");
		int oI = sc.nextInt();
		for(int i = 1; i <= oI; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameItem = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			
			Product product = new Product(nameItem, price);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();

	}

}
