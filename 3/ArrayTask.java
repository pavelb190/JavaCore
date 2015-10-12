
import java.util.Random;


public abstract class ArrayTask {
	
	private final String title;
	private static Random generator = new Random(5000L);
	
	public ArrayTask(String title) {
		this.title = title;
	}
	public ArrayTask() {
		this.title = new String("");
	}
	
	public String getTitle() {
		
		return title;
	}
	public static Random getRandomGenerator() {
		
		return generator;
	}
	
	public abstract void inputData();
	public abstract void randomInitialize();
	public abstract void performTask();
	public abstract void outputResult();
}