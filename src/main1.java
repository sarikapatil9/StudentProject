import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		System.out.println("*******************start of student test ***********************");
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student name:");
		String name=scanner.next();
		
		System.out.println("Enter Student id:");
		int id=scanner.nextInt();
		
		System.out.println("Enter Student age:");
		int age=scanner.nextInt();
		
		
		Student student1 = new Student(id, name, age);
		
		System.out.println(student1);
	}

}
