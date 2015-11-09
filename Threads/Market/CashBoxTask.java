
import java.util.List;

import java.util.concurrent.locks.ReentrantLock;


public class CashBoxTask implements Runnable {

	private static final ReentrantLock lock = new ReentrantLock();

	private static int _id = 0;

	private int id = ++_id;

	private Buyer buyer = null;

	public CashBoxTask(Buyer buyer) {

		this.buyer = buyer;
	}

	public void run() {

		lock.lock();

		try {

			System.out.println("Buyer#" + buyer.getId() + ", Items: ");

			List<? extends Product> items = buyer.getItems();

			for(Product item : items) {

				System.out.println("\t" + item);
			}

			try {

				Thread.sleep(650);

			} catch (InterruptedException e) {

				e.printStackTrace();

				// ...
			}
			
		} finally {

			lock.unlock();
		}
	}
}