
public class StudentNotFound extends Exception {

	StudentNotFound(int id){
		System.err.println("the student with id:"+id+"not found in student database");
	}
}
