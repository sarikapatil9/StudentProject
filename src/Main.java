import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws StudentNotFound {

		System.out.println("*******************start of student test ***********************");
		Student student1 = new Student(11, "sarika", 25);
		Student student2 = new Student(22, "somashekar", 28);
		Student student3 = new Student(33, "aditya", 19);

		System.out.println(student1);

		student1.enrollCourse("selenium");
		student1.enrollCourse("selenium");
		student1.enrollCourse("appium");

		student2.enrollCourse("c++");
		student2.enrollCourse("linux");
		student2.enrollCourse("personality development");

		student3.enrollCourse("english");
		student3.enrollCourse("maths");
		student3.enrollCourse("science");

		System.out.println(Student.listofstudents.size());

		for (int i = 0; i < Student.listofstudents.size(); i++) {
			System.out.println(Student.listofstudents.get(i));
		}
		student3.findStudentById(88);

		sortbyName();
		System.out.println("*******************end of student test ***********************");

	}

	private static void sortbyName() {
		Comparator<Student> studentNameComperator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());

			}
		};
		Collections.sort(Student.listofstudents, studentNameComperator);
		System.out.println(Student.listofstudents);

	}
}
