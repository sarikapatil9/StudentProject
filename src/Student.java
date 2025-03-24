import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private int studentId;
	private String name;
	private int age;
	private ArrayList<String> courses;

	static List<Student> listofstudents = new ArrayList<Student>();

	public Student(int studentId, String name, int age) {
		super();
		if (validateAge(age) && validateName(name) && validtaeStudentID(studentId)) {
			listofstudents.add(this);
			this.studentId = studentId;
			this.name = name;
			this.age = age;
			this.courses = new ArrayList<String>();
		}
		else {
			throw new RuntimeException("unable to initialize the student: wrong data Given , Please try again");
		}
		
	}

	private boolean validtaeStudentID(int studentId) {
		if (studentId >= 1 && studentId <= 1000)
			return true;
		else {
			System.err.println("Student id should be in the range 1 to 1000 only");
			return false;

		}
	}

	private boolean validateCourse(String course) {
		if (course.equalsIgnoreCase("java")||course.equalsIgnoreCase("dsa")||course.equalsIgnoreCase("api")||course.equalsIgnoreCase("selenium"))
			return true;
		else {
			System.err.println("you can enroll only for java/dsa/api/selenium courses only");
			return false;
		}
	}

	private boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(name);

		if (matcher.matches())
			return true;
		else
			System.err.println("the entered name does not match the criteria,please enter a valid name");
		return false;
	}

	public boolean validateAge(int age) {
		if (age > 16 && age < 40) {
			return true;
		} else
			System.err.println("your age does not meet the criteria of age>18 and age<40");
		return false;
	}

	public void enrollCourse(String course) {
		if (!courses.contains(course)) {
			if (validateCourse(course))
				courses.add(course);
		} else
			System.err.println("Student is already enrolled to the course");
	}

	public void printStudentInfo() {
		System.out.println(
				"Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", courses=" + courses + "]");
	}

	public static void findStudentById(int studentId) {

		try {
			Student stsudent = listofstudents.stream().filter(x -> x.getStudentId() == studentId).findFirst()
					.orElseThrow(() -> new RuntimeException("no data found"));
		} catch (RuntimeException exc) {
			System.err.println("Student with StudentID: " + studentId + " not found");
		}

	}

	public static Student findStudentById1(int studentId) throws StudentNotFound {

		for (Student student : listofstudents) {
			if (student.studentId == studentId) {
				return student;
			}
		}
		Student stsudent = listofstudents.stream().filter(x -> x.getStudentId() == studentId).findFirst()
				.orElseThrow(() -> new RuntimeException("no data found"));

		throw new StudentNotFound(studentId);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	public static List<Student> getListofstudents() {
		return listofstudents;
	}

	public static void setListofstudents(List<Student> listofstudents) {
		Student.listofstudents = listofstudents;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", courses=" + courses + "]";
	}

}
