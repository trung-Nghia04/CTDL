package task_2;

public class Test {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(4);
		list.addFirst(7);
		list.addLast(5);
		list.addLast(9);
		System.out.println("Danh sách hiện tại: " + list.toString());
		System.out.println("Số phần tử trong danh sách: " + list.size());
		System.out.println("Danh sách trống: " + list.isEmpty());
		System.out.println("Phần tử đầu tiên trong danh sách: " + list.first());
		System.out.println("Phần tử cuối cùng trong danh sách: " + list.last());
		list.removeFirst();
		System.out.println("Xóa phần tử đầu tiên: " + list.toString());
		list.removeLast();
		System.out.println("Xóa phần tử cuối cùng: " + list.toString());

	}
}
