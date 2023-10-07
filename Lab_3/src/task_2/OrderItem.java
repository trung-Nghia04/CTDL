package task_2;

public class OrderItem {
	private Product p;
	private int quanlity;

	public OrderItem(Product p, int quanlity) {
		this.p = p;
		this.quanlity = quanlity;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuality() {
		return quanlity;
	}

	public void setQuality(int quality) {
		this.quanlity = quality;
	}

	@Override
	public String toString() {
		return p + ": " + quanlity + "\n";
	}

}
