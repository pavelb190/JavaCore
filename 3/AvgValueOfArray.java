
import java.util.Scanner;

public class AvgValueOfArray {

	private float[] array = null;
	
	public AverageValueOfArray(int size) {
		array = new float[size];
	}
	
	public static void main(String[] args) {
		final int n = 10;
		AverageValueOfArray arrAvg = new AverageValueOfArray(n);
		arrAvg.inputData();
		System.out.printf("Average value = %f", arrAvg.calc());
	}
	
	public void printArray() {
		StringBuilder strFormatted = new StringBuilder("");
		for(int i = 0; i < array.length; i++) {
			strFormatted.append(array[i] + "|");
		}
		strFormatted.deleteCharAt(strFormatted.length() - 1);
		System.out.println(strFormatted);
		//System.out.println(String.join("|", array));
	}
	
	public void inputData() {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < array.length; i++) {
			System.out.printf("Enter a [%d]-value: ", i);
			array[i] = in.nextFloat();
		}
	}
	
	public float calc() {
		float sum = 0f;
		int i = 0,
			n = array.length;
			
		while (i < n) {
			sum += array[i];
			i++;
		}
		return (sum / n);
	}
}