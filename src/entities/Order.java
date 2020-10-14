package entities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import enun.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> listOrderItem = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getListOrderItem() {
		return listOrderItem;
	}

	public void addItem(OrderItem orderItem) {
		listOrderItem.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		listOrderItem.remove(orderItem);
	}

	public Double total() {
		
		double sum = 0;
		
		for (OrderItem orderItem : listOrderItem) {
			sum += orderItem.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		double amount = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sbr = new StringBuilder();
		sbr.append("ORDER SUMMARY \n");
		sbr.append("Order Moment: " + sdf.format(getMoment()) + "\n");
		sbr.append("Order Status:" + getStatus() + "\n");
		sbr.append("Client:" + getClient().getName() + " (" + sdf1.format(getClient().getBirthDate()) + ") - " + getClient().getEmail() + "\n");
		sbr.append("Order Itens: \n");
		for (OrderItem item : listOrderItem) {
			sbr.append(item.getProduct().getName() + ", $" + String.format("%.2f", item.getPrice()) + " Quantity: " + item.getQuantity() + ", " + "Subtotal: $" + String.format("%.2f", item.subTotal()) + "\n");
			amount += item.subTotal();
		}
		sbr.append("\nTotal price: $" + String.format("%.2f", amount));
		return sbr.toString();
	}
	
}
