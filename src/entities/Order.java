package entities;


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

	public Order(Date moment, OrderStatus status, Client client, List<OrderItem> listOrderItem) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.listOrderItem = listOrderItem;
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


	public void addListOrderItem(OrderItem orderItem) {
		listOrderItem.add(orderItem);
	}
	
	public void removeListOrderItem(OrderItem orderItem) {
		listOrderItem.remove(orderItem);
	}
	
}
