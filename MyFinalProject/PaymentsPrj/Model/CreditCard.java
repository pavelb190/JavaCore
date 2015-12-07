

public class CreditCard extends Entity {

	private String num;

	private long accountId;

	public String getNum() {

		return this.num;
	}

	public void setNum(final String num) {

		this.num = num;
	}

	public long getAccountId() {

		return this.accountId;
	}

	public void setAccountId(final long accountId) {

		this.accountId = accountId;
	}
}