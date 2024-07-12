package task_1;

import java.util.Date;
import java.util.List;

public class Order {
	private String id;
	private String customer;
	private String employee;
	private Date date;
	private List<OrderItem> items;

	public Order(String id, String customer, String employee, Date date, List<OrderItem> items) {
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public String getCustomer() {
		return customer;
	}

	public String getEmployee() {
		return employee;
	}

	public Date getDate() {
		return date;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public int getCost() {
		int res = 0;
		for (OrderItem item : items) {
			res += item.getAmount() * item.getItem().getPrice();
		}
		return res;
	}

	@Override
	public String toString() {
		return "\nOrder: '" + id + '\'' + ", '" + customer + '\'' + ", '" + employee + '\'' + ", " + date.getDay() + "/"
				+ date.getMonth() + "/" + date.getYear() + ", " + items + "\n\tTocal cost : " + getCost();
	}
}