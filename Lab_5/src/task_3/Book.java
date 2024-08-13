package task_3;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private String id;
	private String title;
	private double price;
	private String type;
	private int year;
	private List<Author> authors = new ArrayList<>();

	public Book(String id, String title, double price, String type, int year) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.type = type;
		this.year = year;
	}

	public void addAuthor(Author a) {
		this.authors.add(a);
	}

	public int getYear() {
		return year;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", type=" + type + ", year=" + year
				+ ", authors=" + authors + "]" + "\n";
	}

}
