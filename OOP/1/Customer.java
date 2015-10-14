
public class Customer {
	private static long maxId = 0;
	private long id;
	private String name;
	private String surname;
	private String address;
	private long creditCardNumber;
	private long bankAccountNumber;
	public Customer() {
		setId(0);
	}
	public Customer(String name, String surname) {
		setId(0);
		setName(name);
		setSurname(surname);
	}
	public Customer(String name, String surname, String address) {
		this(name, surname);
		setAddress(address);
	}
	private static long getNextId() {
		
		return (++maxId);
	}
	private void setId(long id) {
		this.id = (id > 0 ? id : getNextId());
	}
	public long getId() {
		
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		
		return this.name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		
		return this.surname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		
		return this.address;
	}
	public void setCreditCardNumber(long number) {
		this.creditCardNumber = number;
	}
	public long getCreditCardNumber() {
		
		return this.creditCardNumber;
	}
	public void setBankAccountNumber(long number) {
		this.bankAccountNumber = number;
	}
	public long getBankAccountNumber() {
		
		return this.bankAccountNumber;
	}
	private static String hideChars(final String src, int percentage, final char hideSign) {
		
		char[] chars = src.toCharArray();
		
		int str_len = chars.length;
		int startFrom = str_len - (int)Math.round((double)(str_len * percentage) / 100);
		
		for(int i = startFrom; i < chars.length; i++) {
			chars[i] = hideSign;
		}
		
		return new String(chars);
	}
	public String toString() {
		
		//Adding of Address;
		boolean addressExists = (this.address.length() > 0);
		
		//Sign for Replacement;
		final char hide_sign = '*';
		
		/* Formatting CreditCardNumber. */
		final String creditCardNumber = String.valueOf(this.creditCardNumber);
		
		int hide_n = 90;	//Percentage;
		String ccnHidden = hideChars(creditCardNumber, hide_n, hide_sign);
		
		/* Formatting BankAccountNumber. */
		final String bankAccountNumber = String.valueOf(this.bankAccountNumber);
		
		hide_n = 75;	//Percentage;
		String banHidden = hideChars(bankAccountNumber, hide_n, hide_sign);
		
		return String.format("%9s %12s %12s: c/n: %12s, b/n: %12s.", this.name, this.surname, (addressExists ? "("+ this.address +")" : "(<None>)"), ccnHidden, banHidden);
	}
}