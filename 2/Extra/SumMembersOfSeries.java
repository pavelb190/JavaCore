
import java.util.Scanner;

public class SumMembersOfSeries {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number of members: ");
		int n = in.nextInt();
		double s = 0;
		for(int i = 1; i <= n; i++) {
			s += 1.0 / i;
		}
		System.out.println("Sum Members of series: " + s);
	}
}