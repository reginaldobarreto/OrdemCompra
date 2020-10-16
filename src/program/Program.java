package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enun.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
					
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTER CLIENT DATA");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Birth date (DD/MM/YYYY):");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String source = sc.next();
		Date birthDate = sdf.parse(source);
	
		Client client = new Client(name, email, birthDate);
		
		System.out.println("ENTER ORDER DATA");
		System.out.print("Order Status (PENDING_PAYMENT,PROCESSING,SHIPPED,DELIVERED) :");
		String orderStatus  = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus.toUpperCase()), client);
		
		System.out.println("How many itens to this order ? :");
		int amountOrder = sc.nextInt();
		
		for (int i = 0; i < amountOrder ; i++) {
			
			System.out.println("ENTER # " + (i+1) + " ITEM DATA");
			System.out.print("Product name: ");
			sc.nextLine();
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			Double prodPrice = sc.nextDouble();
			System.out.print("Quantity : ");
			int quantity = sc.nextInt();
			Product product = new Product(prodName, prodPrice);
			OrderItem orderItem = new OrderItem(quantity, product.getPrice(), product);
			order.addItem(orderItem);
		}
		
		
		sc.close();
		
		System.out.println();
		System.out.println(order);
		
		
	}

}
