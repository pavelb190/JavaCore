

public class Transaction extends Entity {

	private long accountId;

	private double moneyAmount;

	private final boolean isPayment;

	private String description;

	public long getAccountId() {

		return this.accountId;
	}

	public void setAccountId(final long accountId) {

		this.accountId = accountId;
	}

	public double getMoneyAmount() {

		return this.moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {

		this.moneyAmount = moneyAmount;
	}

	public boolean isPayment() {

		return this.isPayment;
	}

	public void isPayment(boolean isPayment) {

		this.isPayment = isPayment;
	}

	public String getDescription() {

		return this.description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}