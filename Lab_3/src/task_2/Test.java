package task_2;

public class Test {
	public static void main(String[] args) {

		Student st1 = new Student("001", "NVA", 2022);
		Student st2 = new Student("002", "NVB", 2023);
		Student st3 = new Student("003", "NVC", 2022);
		Student st4 = new Student("004", "NVD", 2023);
		Student st5 = new Student("005", "NVE", 2022);
		Student st6 = new Student("006", "NVF", 2021);

		Course c1 = new Course("1", "CTDL", "thuc hanh", "GV1");
		Course c2 = new Course("2", "LTNC", "thuc hanh", "GV2");
		Course c3 = new Course("3", "LTDT", "ly thuyet", "GV3");
		Course c4 = new Course("4", "LTCB", "Ly thuyet", "GV4");

		c1.addStudent(st1);
		c1.addStudent(st3);
		c1.addStudent(st5);
		c1.addStudent(st6);

		c2.addStudent(st2);
		c2.addStudent(st4);

		c3.addStudent(st6);
		c3.addStudent(st5);

		c4.addStudent(st5);

		Faculty faculty = new Faculty("CNTT", "HO CHI MINH");
		faculty.addCourse(c1);
		faculty.addCourse(c2);
		faculty.addCourse(c3);
		faculty.addCourse(c4);
		System.out.println(faculty);
		System.out.println("-----------------------------------");
		System.out.println("getMaxPracticalCourse: \n" + faculty.getMaxPracticalCourse());
		System.out.println("-----------------------------------");
		System.out.println("so luong sv khoa 2022: " + faculty.countStudentsByYear(2022));
		System.out.println("-----------------------------------");
		System.out.println("danh sach course type thuc hanh: \n" + faculty.filterCourses("thuc hanh"));
	}
}
