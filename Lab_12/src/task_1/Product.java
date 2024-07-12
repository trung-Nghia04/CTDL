package task_1;

import java.util.Date;

public class Product {
	private String name;
	private String type;
	private int price;
	private Date expiredDate;

	public Product(String name, String type, int price, Date expiredDate) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.expiredDate = expiredDate;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product: " + name + '\'' + ", '" + type + '\'' + ", " + price + ", " + expiredDate.getDay() + "/"
				+ expiredDate.getMonth() + "/" + expiredDate.getYear();
	}

	public int hasMorePrice(OrderItem o) {
		return price - o.getItem().price;
	}
}