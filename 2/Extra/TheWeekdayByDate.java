
import java.util.Scanner;

public class TheWeekdayByDate {
	public static void main(String[] args) {
		TheWeekdayByDate wd = new TheWeekdayByDate();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a date: ");
		String date = in.nextLine();
		String[] parts = date.split("\\.");
		int d = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int y = Integer.parseInt(parts[2]);
		System.out.println(wd.findDayNumOfWeek(d, m - 1, y));
	}
	private int findDayNumOfWeek(int day, int month, int year) {
		int d = month + 1;
		final int fromMonth = 3;	//to count from March;
		int mm = d - fromMonth + 1;
		int m = mm < 1 ? 12 + mm : mm;
		String yyy = String.valueOf(year);
		int y = Integer.parseInt(yyy.substring(yyy.length() - 2)) + 1;
		int c = year / 100;
		//System.out.println("d=" + d + ", m=" + m + ", Y=" + y + ", c=" + c);
		return ((d + (int)(1.0/5 * (13*m - 1)) + y + (int)(y/4) + (int)(c/4) - 2*c + 777) % 7);
	}
}
