
import java.util.List;
import java.util.LinkedList;


public class TestDemo {

	private static List<? extends Buyer> buyers = new LinkedList<Buyer>() {{

		//Buyer-buffer:
		Buyer buyerBuff = new Buyer();

		//Buyer#1:
		buyerBuff.addItem(new Product("A1", 123));
		buyerBuff.addItem(new Product("B1", 456));

		add(buyerBuff);

		//Buyer#2:
		buyerBuff = new Buyer();

		buyerBuff.addItem(new Product("A2", 789));
		buyerBuff.addItem(new Product("B2", 456));

		add(buyerBuff);

		//Buyer#3:
		buyerBuff = new Buyer();

		buyerBuff.addItem(new Product("A3", 789));
		buyerBuff.addItem(new Product("B3", 456));
		buyerBuff.addItem(new Product("C3", 123));
		buyerBuff.addItem(new Product("D3", 456));

		add(buyerBuff);

		//Buyer#4:
		buyerBuff = new Buyer();

		buyerBuff.addItem(new Product("A4", 789));
		buyerBuff.addItem(new Product("B4", 456));
		buyerBuff.addItem(new Product("C4", 123));

		add(buyerBuff);

		//Buyer#5:
		buyerBuff = new Buyer();

		buyerBuff.addItem(new Product("A5", 789));
		buyerBuff.addItem(new Product("B5", 456));
		buyerBuff.addItem(new Product("C5", 123));
		buyerBuff.addItem(new Product("D5", 123));

		add(buyerBuff);
	}};

	public static void main(String[] args) {

		//PrintArrayTask task = new PrintArrayTask(650);
		/*
		new Thread(task).start();
		new Thread(task).start();
		*/

		//new CashBoxTask(buyers.get(0)).run();

		Market market = new Market(2);

		market.serveCustomers(buyers);

		//System.out.println(new Product("AAA", 123));

		//new Thread(new PrintArrayTask(650)).start();
		//new Thread(new PrintArrayTask(950)).start();
	}
}