
public class TestDemo {
	public static void main(String[] args) {
		
		//Creates an array of Customers;
		Customer[] customers = buildCustomerList();
		
		//Prints out an source array of Customers;
		System.out.println("[Source array of Customers]: ");
		printList(customers);
		System.out.println();
		
		//"CreditCardNumber" range values;
		long fromRange = 0L, toRange = 1000L;
		
		//#Task b):
		Customer[] taskBResult = getByCreditCardNumberInRange(customers, fromRange, toRange);	//result Customer array;
		
		System.out.printf("[Customers with credit card number between %d and %d, (%d totals)]: \n", fromRange, toRange, taskBResult.length);
		printList(taskBResult);
		System.out.println();
		
		//Sort direction value:
		boolean asc = true;
		
		//#Task a):
		
		orderByName(customers, asc);
		
		System.out.printf("[Customers sorted by name in %s order]:\n", (asc ? "ascending" : "descending"));
		printList(customers);
	}
	/**
	* Builds an array of Customers for use in program.
	*/
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
	/**
	* Exchanges two elements in array by specified positions (a,b).
	*/
	private static void swapObjects(Object[] objects, int a, int b) {
		Object t = objects[a];
		objects[a] = objects[b];
		objects[b] = t;
	}
	/**
	* Sorts an array of Customers by their name (i.e. name+surname raw) with specified direction of sorting (ascending or descending).
	*/
	private static void orderByName(Customer[] customers, boolean asc) {
		String fullName_i = null, fullName_j = null;
		int i, j;
		for(i = 0; i < customers.length - 1; i++) {
			for(j = i + 1; j < customers.length; j++) {
				fullName_i = customers[i].getName() + " " + customers[i].getSurname();	//set "FullName"-string for element[i];
				fullName_j = customers[j].getName() + " " + customers[j].getSurname();	//set "FullName"-string for element[j];
				//Compare two fullNames lexicographically...
				if ((asc && fullName_j.compareTo(fullName_i) < 0) || (!asc && fullName_j.compareTo(fullName_i) > 0)) {
					//if true, do exchange them...
					swapObjects(customers, j, i);
				}
			}
		}
	}
	/**
	* Finds all customers a "CreditCardNumber"-field value of which is between from and to.
	*/
	private static Customer[] getByCreditCardNumberInRange(Customer[] customers, long from, long to) {
	
		//Max size of Result array;
		final int n = customers.length;		
		
		//Array of Customers matching for condition;
		Customer[] matchingCustomers = new Customer[n];
		
		int iCurr = 0;	//current position for inserting a new Customer;
		for(Customer c : customers) {
			//Check if "CreditCardNumber" is in a Range;
			if (from <= c.getCreditCardNumber() && c.getCreditCardNumber() <= to) {
				matchingCustomers[iCurr++] = c;	//Add in... and set a next insert position index;
			}
		}
		return matchingCustomers;	//Return matched Customers array;
	}
	/**
	* Prints out an array of Objects in console using their method toString().
	*/
	private static void printList(Object[] list) {		//It must be applied for Arrays only! (1)
		for(Object elem: list) {
			//It works for Arrays only! (#1)
			if (elem != null) {
				System.out.println(elem);
			}
		}
	}
}