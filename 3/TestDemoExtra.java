
import Tasks.Extra.ArrMakeOrderedDiagonal;

public class TestDemoExtra {
	public static void main(String[] args) {
		ArrMakeOrderedDiagonal task = new ArrMakeOrderedDiagonal(4, "Integer");
		//task.randomInitialize();
		task.inputData();
		task.performTask();
		task.outputResult();
	}
}