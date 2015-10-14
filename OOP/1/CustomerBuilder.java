
public class CustomerBuilder {
	
	private static CustomerBuilder self = null;
	
	private Customer customer = null;
	
	private CustomerBuilder(String name, String surname) {
		
		this.customer = new Customer(name, surname);
	}
	
	public static CustomerBuilder create(String name, String surname) {
		
		self = new CustomerBuilder(name, surname);
		
		return self;
	}
	
	public CustomerBuilder setAddress(String address) {
		
		this.customer.setAddress(address);
		
		return self;
	}
	public CustomerBuilder setCreditCardNumber(long number) {
		
		this.customer.setCreditCardNumber(number);
		
		return self;
	}
	public CustomerBuilder setBankAccountNumber(long number) {
		
		this.customer.setBankAccountNumber(number);
		
		return self;
	}
	public Customer get() {
		
		return this.customer;
	}
	public Customer getInstance() {
		
		return this.customer;
	}
}