package task_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	private String name, address;
	private List<Course> courses = new ArrayList<>();

	public Faculty(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Course getMaxPracticalCourse() {
		Course re = null;
		int max = 0;
		for (int i = 0; i < courses.size(); i++) {
			Course ci = courses.get(i);
			if (ci.isPratical() && ci.getStudents().size() > max) {
				max = ci.getStudents().size();
				re = ci;
			}
		}

		return re;
	}

	public void addCourse(Course c) {
		courses.add(c);
	}

	public int countStudentsByYear(int year) {
		Set<Student> set = new HashSet<>();
		for (Course c : courses) {
			set.addAll(c.countStudentsByYear(year));
		}
		return set.size();
	}

	public Set<Course> filterCourses(String type) {
		TreeSet<Course> re = new TreeSet<>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				int re = o2.getStudents().size() - o2.getStudents().size();
				if (re == 0) {
					return o2.getId().compareTo(o1.getId());
				} else {
					return re;
				}
			}
		});
		for (Course c : courses) {
			if (c.kt(type))
				re.add(c);
		}
		return re;
	}

	@Override
	public String toString() {
		return "Faculty " + name + ", address: " + address + ", courses: \n" + courses;
	}

}
