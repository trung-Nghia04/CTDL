package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TestMyPredicates {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Test the remove method
        System.out.println("Danh sách gốc: " + numbers);
        MyPredicates.remove(numbers, new Even());
        System.out.println("Sau khi loại bỏ số chẵn: " + numbers + "\n");

        // Test the retain method
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("Danh sách gốc: " + numbers);
        MyPredicates.retain(numbers, new Even());
        System.out.println("Sau khi loại bỏ số lẻ: " + numbers+ "\n");

        // Test the collect method
        numbers.clear();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        System.out.println("Danh sách gốc: " + numbers);
        Set<Integer> evenNumbers = MyPredicates.collect(numbers, new Even());
        System.out.println("Các số chẵn trong tập hợp: " + evenNumbers+ "\n");

        // Test the find method
        numbers.clear();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        System.out.println("Danh sách gốc: " + numbers);
        int index = MyPredicates.find(numbers, new Even());
        if (index != -1) {
            System.out.println("Số nằm ở vị trí số 1: " + index);
        } else {
            System.out.println("Không tìm thấy số nằm ở vị trí số 1");
        }
    }
}
