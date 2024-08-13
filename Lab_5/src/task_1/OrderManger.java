package task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class OrderManger {
	private List<Order> orders = new ArrayList<>();

	public OrderManger() {
	}

	public void addOrder(Order o) {
		orders.add(o);
	}

	public Product maxProduct() {
		Comparator<Product> comp = Comparator.comparing(Product::getPrice);
		return orders.stream().flatMap(x -> x.getItems().stream()).map(x -> x.getItem()).max(comp).get();
	}

	public Map<String, Integer> productTypesStatistics() {
		return orders.stream().flatMap(x -> x.getItems().stream())
				.collect(Collectors.toMap(OrderItem::getType, OrderItem::getAmount, Integer::sum));
	}

	public TreeSet<Order> ordersByCost() {
		Comparator<Order> orderComparator = Comparator.comparingInt(Order::cost).reversed()
				.thenComparing(Order::getDate);
		return orders.stream().collect(Collectors.toCollection(() -> new TreeSet<>(orderComparator)));
	}

	public List<Order> getOrderIn2024() {
		return orders.stream().filter(Order::is2024).collect(Collectors.toList());
	}

	public List<Order> recenttOder() {
		return orders.stream().sorted(Comparator.comparing(Order::getDate).reversed()).limit(3).toList();
	}

	@Override
	public String toString() {
		return "OrderManger [orders=" + orders + "]";
	}

}