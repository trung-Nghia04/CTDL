package task_2;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("001", "Điện thoại", 100, "IP");
		Product p2 = new Product("002", "máy tính", 200, "acer");
		Product p3 = new Product("003", "chuột", 90, "IP");
		Product p4 = new Product("004", "bàn phím", 80, "IP");

		OrderItem item_1 = new OrderItem(p1, 2);
		OrderItem item_2 = new OrderItem(p2, 2);
		OrderItem item_3 = new OrderItem(p3, 2);
		OrderItem item_4 = new OrderItem(p4, 2);
		Order order = new Order();
		order.addItem(item_1);
		order.addItem(item_2);
		order.addItem(item_3);
		order.addItem(item_4);
		System.out.println("danh sách các sản phẩm ");
		System.out.println(order);
		System.out.println("cost = " + order.cost());
		System.out.println("kiểm tra sản phầm có trong danh  sách nếu có trả về true");
		System.out.println(order.contains(new Product("001", "Điện thoại", 100, "IP")));
		System.out.println(order.contains(new Product("005", "tai nghe", 20000, "type2")));
		System.out.println(order.contains(new Product("004", "bàn phím", 80, "IP")));
		Product[] products = order.filter("IP");
		System.out.println("các sản phẩm loại IP: ");
		for (Product product : products) {
			System.out.println(product.getName() + " - " + product.getType());
		}
	}

}
