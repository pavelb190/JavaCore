
import java.util.Scanner;

public class Calculator {
	private static final String EXIT_FLAG = "q";
	private double value = 0;
	public Calculator() {
		this.value = 0;
	}
	public Calculator(double defaultValue) {
		this.value = defaultValue;
	}
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		Scanner in = new Scanner(System.in);
		String input = null;
		double value = 0;	//for user input of a value;
		do {
			if (input != null) {
				if (input.contains("r")) {
					calc.reset();
				} else {
					System.out.print("Enter a value: ");
					value = in.nextDouble();
					//in.close();
					in = new Scanner(System.in);
					if (input.contains("+")) {
						calc.add(value);
					} else if (input.contains("-")) {
						calc.subtract(value);
					} else if (input.contains("*")) {
						calc.multiply(value);
					} else if (input.contains("/")) {
						calc.divide(value);
					}
				}
			}
			System.out.println("Current value: " + calc.getValue());
			System.out.print("Select operation (r - Reset, +, -, *, /, q - Exit): ");
		} while(!(input = in.nextLine()).contains(EXIT_FLAG));
	}
	public void add(double value) {
		this.value += value;
	}
	public void multiply(double value) {
		this.value *= value;
	}
	public void subtract(double value) {
		this.value -= value;
	}
	public void divide(double value) {
		this.value /= value;
	}
	public void reset() {
		this.value = 0;
	}
	public double getValue() {
		return this.value;
	}
	public void setValue(double value) {
		this.value = value;
	}
}