
import java.util.List;
import java.util.LinkedList;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Market {

	private int cashes = 0;

	public Market(int cashes) {

		this.cashes = cashes;
	}

	public void serveCustomers(List<? extends Buyer> buyers) {

		ThreadPoolExecutor market = (ThreadPoolExecutor) Executors.newFixedThreadPool(this.cashes);

		for(Buyer buyer : buyers) {

			market.execute(new CashBoxTask(buyer));
		}

		market.shutdown();
	}
}