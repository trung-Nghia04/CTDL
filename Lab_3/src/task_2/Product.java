package task_2;

public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;

	}

	@Override
	public int compareTo(Product other) {
		// So sánh theo thứ tự từ điển của id
		int idCompare = this.id.compareTo(other.id);
		if (idCompare != 0) {
			return idCompare;
		}

		// Nếu id bằng nhau, so sánh theo thứ tự từ điển của name
		int nameCompare = this.name.compareTo(other.name);
		if (nameCompare != 0) {
			return nameCompare;
		}

		// Nếu id và name đều bằng nhau, trả về 0
		return 0;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return id + ": " + name + ": " + price + ": " + type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
