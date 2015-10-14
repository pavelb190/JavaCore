
public class TestDemo {
	public static void main(String[] args) {
		Customer[] customers = buildCustomerList();
		System.out.println("[Source list of Customers]: ");
		printList(customers);
	}
	private static Customer[] buildCustomerList() {
		
		return new Customer[]{
				//Customer #1:
				CustomerBuilder.create("Ivan", "Ivanov")
					.setAddress("Minsk")
					.setCreditCardNumber(12367864293L)
						.setBankAccountNumber(873192612374L)
						.getInstance(),
				//Customer #2:
				CustomerBuilder.create("Alexandr", "Alexandrov")
					.setAddress("Moscow")
					.setCreditCardNumber(456L)
						.setBankAccountNumber(789L)
						.getInstance(),
				//Customer #3:
				CustomerBuilder.create("Petr", "Petrov")
					.setAddress("New York")
					.setCreditCardNumber(789L)
						.setBankAccountNumber(012L)
						.getInstance()
			};
	}
	private static void printList(Object[] list) {
		for(Object elem: list) {
			System.out.println(elem);
		}
	}
}