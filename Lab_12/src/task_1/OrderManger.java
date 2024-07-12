package task_1;

import java.util.*;
import java.util.stream.Collectors;

public class OrderManger {
	private List<Order> orders;

	public OrderManger(List<Order> orders) {
		this.orders = orders;
	}

	public Product maxProduct() {
		Comparator<Product> comp = Comparator.comparing(Product::getPrice);
		return this.orders.stream().flatMap(x -> x.getItems().stream()).map(x -> x.getItem()).max(comp).get();
	}

	public HashMap<String, Integer> productTypesStatistics() {
		return orders.stream().flatMap(x -> x.getItems().stream()).collect(Collectors
				.toMap(orderItem -> orderItem.getItem().getType(), OrderItem::getAmount, Integer::sum, HashMap::new));
	}

	public TreeSet<Order> ordersByCost() {
		TreeSet<Order> sorted = new TreeSet<>((o1, o2) -> {
			int byCost = o2.getCost() - o1.getCost();
			int byDate = o1.getDate().compareTo(o2.getDate());
			return byCost == 0 ? byDate : byCost;
		});
		sorted.addAll(orders);
		return sorted;
	}
}