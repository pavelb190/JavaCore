

public class Payment extends Entity {

	private long creditCardId;

	private double paymentAmount;

	private final String paymentPurpose;

	public long getCreditCardId() {

		return this.creditCardId;
	}

	public void setCreditCardId(final long creditCardId) {

		this.creditCardId = creditCardId;
	}

	public double getPaymentAmount() {

		return this.paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {

		this.paymentAmount = paymentAmount;
	}

	public String getPaymentPurpose() {

		return this.paymentPurpose;
	}

	public void setPaymentPurpose(final String paymentPurpose) {

		this.paymentPurpose = paymentPurpose;
	}
}