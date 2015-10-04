
import java.util.Scanner;

public class HelloUser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in, "cp866");
		String name = input.nextLine();
		System.out.println("Привет, " + name + "!");
	}
}