package task_1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Product p1 = new Product("Sach Giao Khoa", "Sach", 20000, new Date(1995, Calendar.JULY, 23));
		Product p2 = new Product("Toi tai gioi, ban tai xiu", "Tap chi", 25000, new Date(2020, Calendar.AUGUST, 23));
		Product p3 = new Product("Hoc cach lam nguoi", "Sach", 10000, new Date(2021, Calendar.OCTOBER, 23));
		Product p4 = new Product("Dac nhan tam", "Tap chi", 30000, new Date(2022, Calendar.FEBRUARY, 23));

		OrderItem orderItem1 = new OrderItem(p1, 1);
		OrderItem orderItem2 = new OrderItem(p2, 3);
		OrderItem orderItem3 = new OrderItem(p3, 5);
		OrderItem orderItem4 = new OrderItem(p4, 6);
		List<OrderItem> orderItems = new ArrayList<>();
		orderItems.add(orderItem1);
		orderItems.add(orderItem2);
		orderItems.add(orderItem3);
		orderItems.add(orderItem4);
		Order order1 = new Order("Order1", "A", "S1", new Date(2023, Calendar.APRIL, 25), randomOrderItems(orderItems));
		Order order2 = new Order("Order2", "B", "S2", new Date(2023, Calendar.JUNE, 25), randomOrderItems(orderItems));
		Order order3 = new Order("Order3", "C", "S3", new Date(2023, Calendar.JULY, 25), randomOrderItems(orderItems));
		Order order4 = new Order("Order4", "D", "S4", new Date(2023, Calendar.AUGUST, 25), randomOrderItems(orderItems));

		List<Order> order = new ArrayList<>();
		order.add(order1);
		order.add(order2);
		order.add(order3);
		order.add(order4);

		OrderManger orderManager = new OrderManger(order);
		System.out.println("max "+orderManager.maxProduct());
		System.out.println(orderManager.productTypesStatistics());
		System.out.println(orderManager.ordersByCost());
	}

	public static List<OrderItem> randomOrderItems(List<OrderItem> orderItems) {
		List<OrderItem> res = new ArrayList<>();
		Collections.shuffle(orderItems);
		int random = new Random().nextInt(1, orderItems.size());
		for (int i = 0; i < random; i++) {
			res.add(orderItems.get(i));
		}
		return res;
	}
}
