package task_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order {
	private String id;
	private String customer;
	private String employee;
	private LocalDate date;
	private List<OrderItem> items = new ArrayList<>();

	public Order(String id, String customer, String employee, LocalDate date) {
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
	}
	
	public void addItem(OrderItem o) {
		items.add(o);
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public boolean is2024() {
		return date.compareTo(LocalDate.of(2024, 5, 1)) >= 0 && date.compareTo(LocalDate.of(2024, 6, 1)) < 0;
	}

	public LocalDate getDate() {
		return date;
	}

	public int cost() {
		return items.stream().mapToInt(OrderItem::getPrice).sum();
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", employee=" + employee + ", date=" + date + ", items="
				+ items + "]\n";
	}
	

}