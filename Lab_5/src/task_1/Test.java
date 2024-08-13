package task_1;

import java.time.LocalDate;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("A", "dien tu", 20, LocalDate.of(2024, 05, 14));
		Product p2 = new Product("B", "dien tu", 22, LocalDate.of(2024, 05, 14));
		Product p3 = new Product("C", "dien tu", 40, LocalDate.of(2024, 05, 10));

		OrderItem oi1 = new OrderItem(p1, 3);
		OrderItem oi2 = new OrderItem(p2, 4);
		OrderItem oi3 = new OrderItem(p3, 2);
		OrderItem oi4 = new OrderItem(p1, 1);

		Order o1 = new Order("001", "X", "E1", LocalDate.of(2024, 5, 2));
		o1.addItem(oi1);
		o1.addItem(oi3);
		Order o2 = new Order("002", "F", "E2", LocalDate.of(2024, 5, 10));
		o1.addItem(oi2);
		o1.addItem(oi3);
		Order o3 = new Order("003", "L", "E1", LocalDate.of(2024, 5, 20));
		o1.addItem(oi1);
		o1.addItem(oi4);
		Order o4 = new Order("004", "S", "E2", LocalDate.of(2024, 2, 2));
		o1.addItem(oi1);
		o1.addItem(oi2);

		OrderManger om1 = new OrderManger();

		om1.addOrder(o1);
		om1.addOrder(o2);
		om1.addOrder(o3);
		om1.addOrder(o4);

		System.out.println(om1.maxProduct());
		Map<String, Integer> re = om1.productTypesStatistics();
		for (String k : re.keySet()) {
			System.out.println("Key: " + k + ", Value: " + re.get(k));
		}
		System.out.println(om1.ordersByCost());
		System.out.println(om1.getOrderIn2024());
		System.out.println(om1.recenttOder());
	}
}
