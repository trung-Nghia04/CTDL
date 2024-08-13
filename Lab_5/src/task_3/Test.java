package task_3;

import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Author a1 = new Author("A", 2000);
		Author a2 = new Author("B", 2000);
		Author a3 = new Author("A", 2001);

		Book b1 = new Book("001", "ABC", 20, "tieu thuyet", 2020);
		b1.addAuthor(a1);
		b1.addAuthor(a3);
		Book b2 = new Book("002", "ABCD", 20, "truyen", 2019);
		b2.addAuthor(a2);
		Book b3 = new Book("003", "ABCDE", 20, "tieu thuyet", 2020);
		b3.addAuthor(a3);
		b3.addAuthor(a2);
		b3.addAuthor(a1);

		Library l1 = new Library("A1");
		l1.addBook(b1);
		l1.addBook(b2);
		l1.addBook(b3);

		System.out.println(l1.getOldestBook());
		Map<Integer, List<Book>> re = l1.getBooksByYears();
		for (Integer k : re.keySet()) {
			System.out.println("Key: " + k + ", Value: " + re.get(k));
		}
		System.out.println(l1.findBooks("A", 2020));

	}
}
