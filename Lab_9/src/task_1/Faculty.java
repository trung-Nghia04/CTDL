package task_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, courses, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(address, other.address) && Objects.equals(courses, other.courses)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses + "]";
	}

	public Course getMaxPracticalCourse() {
		Course c = null;
		int numberMax = 0;
		for (Course course : courses) {
			if (course.getStudents().size() >= numberMax && course.getType().equals("Thực hành")) {
				c = course;
				numberMax = course.getStudents().size();
			}
		}
		return c;

	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> re = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int key = student.getYear();
				List<Student> value = new ArrayList<>();
				if (!re.containsKey(key)) {
					value.add(student);
				} else {
					value = re.get(key);
					if (!value.contains(student))
						value.add(student);
				}
				re.put(key, value);
			}

		}
		return re;

	}

	public Set<Course> filterCourses(String type) {
		Set<Course> filterCourse = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				int s1 = o1.getStudents().size();
				int s2 = o2.getStudents().size();

				return Integer.compare(s2, s1);
			}
		});

		for (Course course : courses) {
			if (course.getType().equals(type)) {
				filterCourse.add(course);
			}
		}
		return filterCourse;
	}

}