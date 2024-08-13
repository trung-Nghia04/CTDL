package task_2;

import java.util.Objects;

public class Student {
	private String id, name;
	private int year;

	public Student(String id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Student " + id + ", name: " + name + ", year: " + year + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && year == other.year;
	}

}
