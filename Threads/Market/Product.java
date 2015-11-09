

public class Product {

	private String name;
	private double price;

	public Product(final String name, double price) {

		this.name = name;
		this.price = price;
	}

	/*
	* Getter&Setters:
	*
	* ...
	*/

	public String toString() {

		return "[" + name + ", $" + price + "]";
	}
}