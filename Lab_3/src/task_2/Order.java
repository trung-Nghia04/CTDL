package task_2;

import java.util.Arrays;

public class Order {
	private OrderItem[] items;

	public double cost() {
		double totalCost = 0.0;
		for (OrderItem item : items) {
			totalCost += item.getP().getPrice() * item.getQuality();
		}
		return totalCost;
	}

	// using binary search approach
	public boolean contains(Product p) {
		int low = 0;
		int high = items.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2; // Tính toán giá trị giữa một cách chính xác để tránh tràn số nguyên

			Product midProduct = items[mid].getP();

			int comparisonResult = midProduct.compareTo(p);

			if (comparisonResult == 0) {
				return true;
			} else if (comparisonResult < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return false;
	}

	// get all products based on the given type using
//	linear search
	public Product[] filter(String type) {
		int soLuongSPTuLuu = 0;

		// Trước hết, đếm số lượng sản phẩm phù hợp với loại
		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) {
				soLuongSPTuLuu++;
			}
		}

		// Tạo một mảng để lưu trữ các sản phẩm đã lọc
		Product[] sanPhamDaLoc = new Product[soLuongSPTuLuu];

		// Sau đó, điền các sản phẩm đã lọc vào mảng sanPhamDaLoc
		int chiSoHienTai = 0;
		for (OrderItem item : items) {
			if (item.getP().getType().equals(type)) {
				sanPhamDaLoc[chiSoHienTai] = item.getP();
				chiSoHienTai++;
			}
		}

		return sanPhamDaLoc;
	}

	public void addItem(OrderItem item) {
		// Kiểm tra xem đơn hàng đã rỗng hay chưa
		if (items == null) {
			items = new OrderItem[0];
		}

		// Thêm mục đơn hàng vào mảng
		OrderItem[] newItems = new OrderItem[items.length + 1];
		System.arraycopy(items, 0, newItems, 0, items.length);
		newItems[items.length] = item;
		items = newItems;

	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

}
