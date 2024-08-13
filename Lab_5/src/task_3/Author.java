package task_3;

public class Author {
	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	// Getters and other methods
	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", birthYear=" + birthYear + "]";
	}
	
}
