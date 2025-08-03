//Question2
import java.util.Scanner;

public class Marks{
	public static void main(String [] args){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the number of students in the class: ");
		int no_of_students = scanner.nextInt();
		
		int[][] students = new int[no_of_students + 1][3];
		
		while (true){
			System.out.println("");
			System.out.println("Welcome user, what action do you want to perform today?");
			System.out.println("Enter 1 to add marks for a New Student.");
			System.out.println("Enter 2 to update the marks for a Subject of a student.");
			System.out.println("Enter 3 to find the Total marks of a student.");
			System.out.println("Enter 4 to find the Average mark of a student.");
			System.out.println("Enter 5 to find the Average mark for a Subject.");
			System.out.println("Enter 6 to display the Marks of all the students.");
			System.out.println("Enter 7 to display the Grades of all the students.");
			System.out.println("Enter 8 to exit the program.");
			System.out.println("");			
			System.out.println("Please enter your choice below: ");
			int choice = scanner.nextInt();
			
			if (choice == 1){
				System.out.println("Please enter the Student ID to add marks: ");
				int student_id = scanner.nextInt();
				
				System.out.println("Enter the marks for Mathematic for Student with ID " + student_id + ": ");
				int mathematics = scanner.nextInt();
				students[student_id][0] = mathematics;
				
				System.out.println("Enter the marks for Chemistry for Student with ID " + student_id + ": ");
				int chemistry = scanner.nextInt();
				students[student_id][1] = chemistry;
				
				System.out.println("Enter the marks for Physics for Student with ID " + student_id + ": ");
				int physics = scanner.nextInt();
				students[student_id][2] = physics;
			}else if(choice == 2){
				System.out.println("Enter the Student ID of the student you want to change the marks of: ");
				int student_id  = scanner.nextInt();
				System.out.println("Enter the Subject ID( Mathematics = 1, Chemistry = 2, Physics = 3) of the subject of which you want to change the marks: ");
				int subject_id = scanner.nextInt();
				String subject;
				if (subject_id  == 1){
					subject = "Mathematics";
				}else if(subject_id == 2){
					subject = "Chemistry";
				}else{
					subject = "Physics";
				}	
				System.out.println("Enter the new marks for "+subject+" : ");
				int updated_marks = scanner.nextInt();
				students[student_id][subject_id - 1] = updated_marks;
			}else if (choice == 3){
				int total_marks = 0;
				System.out.println("Enter the Stubent ID of the student to find total marks: ");
				int student_id = scanner.nextInt();
				for (int i  = 1; i<=no_of_students+1; i++){
					if (i == student_id){
						for(int j = 0; j <=2; j++){
							total_marks = total_marks + students[student_id][j];
						}
					}
				}
				System.out.println("The total marks fro the three subjects for the student with ID " +student_id+" is " + total_marks );
			}else if(choice == 4){
				double average_marks = 0;
				System.out.println("Enter the Stubent ID of the student to find Average marks: ");
				int student_id = scanner.nextInt();
				for (int i  = 1; i<=no_of_students+1; i++){
					if (i == student_id){
						for(int j = 0; j <=2; j++){
							average_marks = average_marks + students[student_id][j];
						}
					}
				}
				average_marks = average_marks/3;
				System.out.printf("The total marks for the three subjects for the student with ID %d is: %.2f\n", student_id, average_marks);

			}else if (choice == 5){
				double average_mark_sub = 0;
				String subject ="";
				System.out.println("Enter the Subject ID( Mathematics = 1, Chemistry = 2, Physics = 3) of the subject of which you want to get the Average marks: ");
				int subject_id = scanner.nextInt();
				for(int i = 1; i < students.length; i++){
					for(int j = 0; j <= 2; j++){
						if(j == subject_id - 1){
							average_mark_sub = average_mark_sub + students[i][subject_id - 1];
						}
					}
				}
				average_mark_sub = average_mark_sub / no_of_students;
				if (subject_id  == 1){
					subject = "Mathematics";
				}else if(subject_id == 2){
					subject = "Chemistry";
				}else{
					subject = "Physics";
				}
				System.out.printf("The Average marks for %s is: %.2f\n", subject, average_mark_sub);

			}else if(choice == 6){
				String subject = "";
				for (int i = 1; i < students.length ; i++) {
					System.out.println("Marks of Student with ID " +i+ " is: " );
					for (int j = 0; j < students[i].length; j++) {
						if (j  == 0){
							subject = "Mathematics";
						}else if(j == 1){
							subject = "Chemistry";
						}else{
							subject = "Physics";
						}
						System.out.println(subject +" :"+ students[i][j]);
						
					}
					System.out.println("");
				}
			}else if(choice == 7){
				grade(students);
			}else{
				break;
			}
		}	
		scanner.close();
	}
	
	public static void grade(int[][] students) {
		String subject = "";
		System.out.println("-------------------------------------------------------");
		System.out.println("ID\tMathematics\tChemistry\tPhysics");
		System.out.println("-------------------------------------------------------");

		for (int i = 1; i < students.length; i++) {
			System.out.print(i + "\t");

			for (int j = 0; j < students[i].length; j++) {
				int mark = students[i][j];
				String grade = "";
				if (mark >= 90) {
					grade = "Grade A";
				} else if (mark >= 80) {
					grade = "Grade B";
				} else if (mark >= 70) {
					grade = "Grade C";
				} else if (mark >= 60) {
					grade = "Grade D";
				} else {
					grade = "Fail";
				}

				System.out.print(grade + "          ");
			}

			System.out.println();
		}

		System.out.println("-------------------------------------------------------");
	}

}	