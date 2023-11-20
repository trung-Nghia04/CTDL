package task_1;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) {
	List<Course> listCourses = new ArrayList<>();
	List<Student> lStudents1 = new ArrayList<>();
	List<Student> lStudents2 = new ArrayList<>();
	List<Student> lStudents3 = new ArrayList<>();
	List<Faculty> faculties = new ArrayList<>();
	
	Course c1 = new Course("1", "LTCB", "Thực hành", lStudents1, "Công Song");
	Course c2 = new Course("2", "LTNC", "Thực hành", lStudents2, "Dũ");
	Course c3 = new Course("3", "GTNM", "Thực hành", lStudents3, "Hùng");
	Course c4 = new Course("3", "GTNM", "Lý thuyết", lStudents3, "Hùng");
	Course c5 = new Course("2", "LTNC", "Lý thuyết", lStudents2, "Dũ");
	
	listCourses.add(c1);
	listCourses.add(c2);
	listCourses.add(c3);
	listCourses.add(c4);
	listCourses.add(c5);
	
	Student s1 = new Student("1", "A", 2023);
	Student s2 = new Student("2", "B", 2022);
	Student s3 = new Student("3", "C", 2022);
	Student s4 = new Student("4", "D", 2024);
	Student s5 = new Student("5", "E", 2021);
	Student s6 = new Student("6", "F", 2022);

	
	lStudents1.add(s1);
	lStudents2.add(s2);
	lStudents2.add(s3);
	lStudents2.add(s4);
	lStudents3.add(s5);
	lStudents3.add(s6);
	
	
	Faculty f1 = new Faculty("Khoa CNTT", "C1", listCourses);
	faculties.add(f1);
	
	System.out.println(f1.getMaxPracticalCourse());
	
	System.out.println(f1.groupStudentsByYear());
	
	System.out.println(f1.filterCourses("Thực hành"));
}
}