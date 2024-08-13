package task_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.accessibility.AccessibleStateSet;

public class Course {
	private String id, title, type;
	private List<Student> students = new ArrayList<>();
	private String lecturer;

	public Course(String id, String title, String type, String lecturer) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.lecturer = lecturer;
	}

	public String getType() {
		return type;
	}

	public List<Student> getStudents() {
		return students;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addStudent(Student st) {
		students.add(st);
	}

	public boolean isPratical() {
		return this.type.equals("thuc hanh");
	}

	public Set<Student> countStudentsByYear(int year) {
		Set<Student> re = new HashSet<>();
		for (Student st : students) {
			if (st.getYear() == year)
				re.add(st);
		}
		return re;
	}

	public boolean kt(String type) {
		return this.type.equals(type);
	}
	

	@Override
	public String toString() {
		return "Course " + id + ", title: " + title + ", type: " + type + ", students:  \n" + students + ", lecturer: "
				+ lecturer + "\n";
	}

}
