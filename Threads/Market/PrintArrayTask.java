
import java.util.concurrent.locks.ReentrantLock;


public class PrintArrayTask implements Runnable {

	//private static final ReentrantLock lock = new ReentrantLock();

	private static int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private int delay = 0;

	public PrintArrayTask(int delay) {

		this.delay = delay;
	}

	public void run() {

		printArray();
	}

	public synchronized void printArray() {

		//lock.lock();

		try {

			for(int i = 0; i < array.length; i++) {

				System.out.println("[" + i + "]: " + array[i]);

				try {

					Thread.sleep(650);

				} catch (InterruptedException e) {

					e.printStackTrace();

					// ...
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

			// ...

		} finally {

			//lock.unlock();
		}
	}
}