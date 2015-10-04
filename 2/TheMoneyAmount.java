
import java.util.Scanner;

public class TheMoneyAmount {
	private int amount = 0;
	public static void main(String[] args) {
		TheMoneyAmount moneyAmount = new TheMoneyAmount();
		int amount = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter your money amount: ");
		amount = in.nextInt();
		moneyAmount.setAmount(amount);
		System.out.println("Your money amount is " + moneyAmount);
	}
	public void setAmount(int n) {
		this.amount = n;
	}
	private String getAmountTitle() {
		if (amount > 0 && amount <= 10) {
			
			return applyRules(amount);
		} else if (amount > 10 && amount < 20) { return "рублей";}
		else {
			
			int ends = getAmountLastNumber();
			
			return applyRules(ends);
		}
	}
	protected String applyRules(int m) {
		if (1 == m) {
			return "рубль";
		} else if (m < 5) {
			return "рубля";
		} else {
			return "рублей";
		}
	}
	private int getAmountLastNumber() {
		
		String amountBuff = String.valueOf(amount);
		
		return Character.getNumericValue(amountBuff.charAt(amountBuff.length() - 1));
	}
	public String toString() {
		
		return (this.amount + " " + getAmountTitle());
	}
}