
import java.util.List;
import java.util.LinkedList;


public class Buyer {

	private static int _id = 0;

	private int id = ++_id;

	private List<? extends Product> items = new LinkedList<Product>();

	public <T extends Product> void addItem(T product) {

		((List)items).add(product);
	}

	public List<? extends Product> getItems() {

		return items;
	}

	public int getId() {

		return this.id;
	}
}