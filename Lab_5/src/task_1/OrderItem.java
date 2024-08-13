package task_1;

public class OrderItem {
	private Product item;
	private int amount;

	public OrderItem(Product item, int amount) {
		this.item = item;
		this.amount = amount;
	}

	public Product getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}

	public String getType() {
		return this.item.getType();
	}
	public int getPrice() {
		return this.item.getPrice();
	}

	@Override
	public String toString() {
		return "OrderItem [item=" + item + ", amount=" + amount + "]\n";
	}
	
}