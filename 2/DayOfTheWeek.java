
import java.util.Scanner;

public class DayOfTheWeek {
	private static final String[] daysOfWeek = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k;
		System.out.print("Enter number of weekday: ");
		k = in.nextInt();
		if (k > 0 && k < 8) {
			System.out.println("Your day is \"" + daysOfWeek[k - 1] + "\"");
		} else {
			System.out.println("Week has only 7 days! (1-7).");
		}
	}
}