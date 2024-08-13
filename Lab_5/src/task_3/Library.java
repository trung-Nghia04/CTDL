package task_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Library {
	private String name;
	private List<Book> books = new ArrayList<>();

	public Library(String name) {
		this.name = name;
	}

	public void addBook(Book b) {
		books.add(b);
	}

	public Book getOldestBook() {
		return books.stream().min(Comparator.comparing(Book::getYear)).get();
	}

	public Map<Integer, List<Book>> getBooksByYears() {
		return books.stream().collect(Collectors.groupingBy(Book::getYear));
	}

	public Set<Book> findBooks(String authorName, int year) {
		return books.stream()
				.filter(x -> x.getYear() == year
						&& x.getAuthors().stream().anyMatch(a -> a.getName().equalsIgnoreCase(authorName)))
				.sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toCollection(HashSet::new));
	}

	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + "]";
	}

}
