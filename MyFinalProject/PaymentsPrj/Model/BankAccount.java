

public class BankAccount extends Entity {

	private String num;

	private long userId;
	
	private double balance;
	private boolean isAvailable;

	public String getNum() {

		return this.num;
	}

	public void setNum(final String num) {

		this.num = num;
	}

	public long getUserId() {

		return this.userId;
	}

	public void setUserId(final long userId) {

		this.userId = userId;
	}

	public double getBalance() {

		return this.balance;
	}

	public void setBalance(double balance) {

		this.balance = balance;
	}

	public boolean isAvailable() {

		return this.isAvailable;
	}

	public void isAvailable(boolean available) {

		this.available = available;
	}
}