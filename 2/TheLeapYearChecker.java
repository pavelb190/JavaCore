
import java.util.Scanner;

public class TheLeapYearChecker {
	public static void main(String[] args) {
		TheLeapYearChecker checker = new TheLeapYearChecker();
		Scanner in = new Scanner(System.in);
		int y; //for user input of the year;
		System.out.print("Enter the year: ");
		y = in.nextInt();
		checker.checkYear(y);
	}
	private boolean isLeapYear(int year) {
		return (year % 4 == 0);
	}
	public void checkYear(int year) {
		if (isLeapYear(year)) {
			System.out.println("The year " + year + " is Leap!");
		} else {
			System.out.println("Sorry...Your year is not Leap!..");
		}
	}
}