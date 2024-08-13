package task_1;

import java.time.LocalDate;

public class Product {
	private String name;
	private String type;
	private int price;
	private LocalDate expiredDate;

	public Product(String name, String type, int price, LocalDate expiredDate) {
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", price=" + price + ", expiredDate=" + expiredDate + "]";
	}
	
	
}