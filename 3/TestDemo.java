
import java.util.Scanner;

public class TestDemo {
	
	//private static long RANDOM_MAX_VALUE = 5000L;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Select a Task (#): ");
		int nTask = in.nextInt();
		ArrayTask task = getTask(nTask);
		execute(task, true);
		System.out.println("Bye! ;)");
	}
	private static ArrayTask getTask(int nTask) {
		ArrayTask arrTask = null;
		switch (nTask) {
			case 1: arrTask = new AvgValueOfArray(10, "Float"); break;
			case 2: arrTask = new ArrMinMaxValue(10, "Integer"); break;
			case 4: arrTask = new ArrMaxElement(15, "Float");
			case 5: arrTask = new ArrMinElement(15, "Double");
			case 6: arrTask = new ArrNegativeCount(15, "Float");
		}
		return arrTask;
	}
	private static void execute(ArrayTask task, boolean autoFill) {
		System.out.println(task.getTitle());
		if (autoFill) {
			System.out.println("Data random initializing...");
			task.randomInitialize();
		}
		else {
			System.out.println("Data input...");
			task.inputData();
		}
		System.out.print("Task Performing...");
		task.performTask();
		System.out.println("Completed.");
		System.out.println("RESULT: ");
		task.outputResult();
	}
}