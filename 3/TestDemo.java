
import Tasks.base.ArrayTask;
import java.util.Scanner;

public class TestDemo {
	
	//private static long RANDOM_MAX_VALUE = 5000L;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int nTask;
		if (args.length > 0) {
			nTask = Integer.parseInt(args[0]);
		}
		else {
			System.out.print("Select a Task (#): ");
			nTask = in.nextInt();
		}
		
		ArrayTask task = null;
		try {
			task = getTask(nTask);
		}
		catch (Exception e) {
			e.printStackTrace();
			// ...
		}
		
		System.out.println("Typing data or auto-fill? [a/t]");
		char answer = in.next().charAt(0);
		boolean autoFill = (answer == 'a' ? true : false);
		
		execute(task, autoFill);
		System.out.println("Bye! ;)");
	}
	private static ArrayTask getTask(int nTask) throws Exception {
		ArrayTask arrTask = null;
		switch (nTask) {
			case 1: arrTask = new Tasks.AvgValueOfArray(10, "Float"); break;
			case 2: arrTask = new Tasks.ArrMinMaxValue(10, "Integer"); break;
			case 4: arrTask = new Tasks.ArrMaxElement(15, "Float"); break;
			case 5: arrTask = new Tasks.ArrMinElement(15, "Double"); break;
			case 6: arrTask = new Tasks.ArrNegativeCount(10, "Float"); break;
			case 7: arrTask = new Tasks.ArrSumToFirstZero(10, "Integer"); break;
			case 8: arrTask = new Tasks.ArrMultiToFirstZero(10, "Double"); break;
			case 9: arrTask = new Tasks.ArrZeroAppend(10, "Float"); break;
			default:
				throw new Exception("This Task is not Specified!");
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