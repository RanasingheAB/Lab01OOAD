//Quetion 1
import java.util.Scanner;
public class Welcome {
  public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your First name: ");
		String fname = scanner.nextLine();
		System.out.println("Enter your Last name: ");
		String lname = scanner.nextLine();
        System.out.println("Welcome to the second Year" + fname+lname);
		scanner.close();
  }
}  