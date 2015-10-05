
import java.util.Scanner;

public class OptimalWeightUserCalc {
	private int userHeight = 0;
	private double userWeight = 0;
	protected double optimalWeight = 0;
	public static void main(String[] args) {
		OptimalWeightUserCalc calc = new OptimalWeightUserCalc();
		int h;	//for user input of height;
		double w;	//for user input of weight;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your height: ");
		h = in.nextInt();
		System.out.print("Enter your weight: ");
		w = in.nextDouble();
		calc.evaluateFor(h, w);
		calc.printRecommends();
		calc.reset();
	}
	public void evaluateFor(int userHeight, double userWeight) {
		this.userHeight = userHeight;
		this.userWeight = userWeight;
		this.optimalWeight = this.userHeight - 100;
	}
	public void printRecommends() {
		if (this.optimalWeight > this.userWeight) {
			System.out.println("ADVICE: You must be a more larger! (+" + (optimalWeight - userWeight) + "kg.)");
		} else if (this.userWeight > this.optimalWeight) {
			System.out.println("ADVICE: You must be a more lesser! (" + (userWeight - optimalWeight) + "kg.)");
		} else {
			System.out.println("Everything is OK, dude!");
		}
	}
	public void reset() {
		this.userWeight = this.userHeight = 0;
	}
}