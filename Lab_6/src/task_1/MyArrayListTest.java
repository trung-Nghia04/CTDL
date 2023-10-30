package task_1;

import java.util.Comparator;

public class MyArrayListTest {
	public static void main(String[] args) {
		// Khởi tạo một danh sách MyArrayList
		MyArrayList<Integer> myList = new MyArrayList<>();

		// Thêm các phần tử vào danh sách
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);

		// Kiểm tra kích thước và trạng thái của danh sách
		System.out.println("Kích thước của danh sách: " + myList.size());
		System.out.println("Danh sách có trống không? " + myList.isEmpty());

		// Lấy phần tử tại chỉ số 2
		System.out.println("Phần tử tại chỉ số 2: " + myList.get(2));

		// Đặt phần tử tại chỉ số 2 thành giá trị 5
		myList.set(2, 5);
		System.out.println("Phần tử tại chỉ số 2 sau khi cập nhật: " + myList.get(2));

		// Nối phần tử đã chỉ định vào cuối danh sách:
		System.out.println("Phần tử đã được nối vào đuôi: " + myList.add(5));

		// Thêm phần tử 6 vào danh sách tại chỉ số 1
		myList.add(1, 6);
		System.out.println("Phần tử tại chỉ số 1 sau khi thêm: " + myList.get(1));

		// Xóa phần tử tại chỉ số 3
		myList.remove(3);
		System.out.println("Kích thước của danh sách sau khi xóa phần tử: " + myList.size());

		// Xóa tất cả các phần tử khỏi danh sách
		myList.clear();
		System.out.println("Kích thước của danh sách sau khi xóa tất cả các phần tử: " + myList.size());

		// Thêm các phần tử 5, 6 và 5 vào danh sách
		myList.add(5);
		myList.add(6);
		myList.add(6);
		myList.add(2);
		myList.add(7);
		myList.add(9);
		System.out.println("Chỉ số cuối cùng của phần tử 5: " + myList.lastIndexOf(5));

		// Chuyển đổi danh sách thành một mảng
		Object[] array = myList.toArray();
		System.out.println("Các phần tử của mảng: ");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// Tạo một bản sao của danh sách
		MyArrayList<Integer> clonedList = myList.clone();
		System.out.println("Danh sách sao chép có giống với danh sách gốc không? " + myList.equals(clonedList));

		// Kiểm tra danh sách có chứa phần tử 6 không?
		System.out.println("Danh sách có chứa phần tử 6 không? " + myList.contains(6));

		// Trả về chỉ số của lần xuất hiện đầu tiên của phần tử 4 trong danh sách
		System.out.println("Chỉ số của phần tử 4: " + myList.indexOf(4));
		// Xóa phần tử 6 khỏi danh sách
		myList.remove(Integer.valueOf(6));

		// Hiển thị danh sách sau khi xóa phần tử
		System.out.println("Danh sách sau khi xóa phần tử:");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println();

		// Sắp xếp danh sách theo thứ tự tăng dần bằng cách sử dụng một Comparator
		myList.sort(Comparator.naturalOrder());

		// Hiển thị danh sách sau khi sắp xếp
		System.out.println("Danh sách sau khi sắp xếp:");
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(myList.get(i) + " ");
		}
		System.out.println();
	}
}
