import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main2 {
	private static Scanner scanner;

	public static void main(String[] args) {
		System.out.println("*******************start of student test ***********************");
		scanner = new Scanner(System.in);
		
		Boolean status = true;
		
		while (status) {
			System.out.println("Select an option:");
			System.out.println("1: Register the student");
			System.out.println("2: Find student with studentID");
			System.out.println("3: List all student information");
			System.out.println("4: List student information in sorted order");
			System.out.println("5: Exit");
			int option = scanner.nextInt();
			
			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentById(88);
				break;
			case 3:
				System.out.println(Student.listofstudents);
				break;
			case 4:
				sortbyName();
				break;
			case 5:
				status = exit();
				System.out.println(" ********** End of Student application ********** 1");
				break;
			default:
				System.out.println("invalid option selected: please enter between 1-5");
				break;
			}
		}

	}

	private static void findStudentById(int i) {
		// TODO Auto-generated method stub
		Student.findStudentById(i);

	}

	private static void enrollStudent(Scanner scanner2) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Student name:");
		String name = scanner.next();

		System.out.println("Enter Student id:");
		int id = scanner.nextInt();

		System.out.println("Enter Student age:");
		int age = scanner.nextInt();

		Student student = new Student(id, name, age);
		System.out.println("Student added successfully");
		System.out.println("Enter the course to be enrolled maximum 5: when done please type Done");

		String courseName;
		while (true) {
			courseName = scanner.next();
			if (courseName.equalsIgnoreCase("Done")) {
				break;
			} else
				student.enrollCourse(courseName);
		}

	}

	private static Boolean exit() {
		return false;

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
