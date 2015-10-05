
import java.util.Scanner;

public class Compare2Numbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b;
		System.out.print("Enter a number (1): ");
		a = in.nextInt();
		System.out.print("Enter a number (2): ");
		b = in.nextInt();
		if (-1 == doCompare(a, b)) {
			System.out.println("The First(" + a + ") is greater than the Second(" + b + ").");
		} else if (1 == doCompare(a, b)) {
			System.out.println("The Second(" + b + ") is greater than the First(" + a + ").");
		}
		else {
			System.out.println("The Values(" + a + ", " + b + ") are equals.");
		}
	}
	
	private static int doCompare(int a, int b) {
		
		return (a > b ? -1 : (b > a ? 1 : 0));
	}
}