
package Tasks.base;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.Locale;


public abstract class ArrayTask_1x1 extends ArrayTask {
	private final String dataType;
	private Object[] array = null;
	public ArrayTask_1x1(final int n, String title, final String dataType) {
		super(title);
		this.dataType = dataType;
		this.array = new Object[n];
	}
	public ArrayTask_1x1(final int n, final String dataType) {
		this.dataType = dataType;
		this.array = new Object[n];
	}
	public String getType() {
		
		return this.dataType;
	}
	public Object[] getData() {
		
		return this.array;
	}
	public void inputData() {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < array.length; i++) {
			System.out.printf("Enter a [%d]-element: ", i);
			switch (dataType) {
				case "Float": 	this.array[i] = in.nextFloat(); break;
				case "Double": 	this.array[i] = in.nextDouble(); break;
				case "Integer":
				default: this.array[i] = in.nextInt();
			}
		}
	}
	public void randomInitialize() {
		Random generator = getRandomGenerator();
		for(int i = 0; i < array.length; i++) {
			switch (dataType) {
				case "Float": 	this.array[i] = generator.nextFloat() * 100; break;
				case "Double": 	this.array[i] = generator.nextDouble() * 100; break;
				case "Integer":
				default: this.array[i] = generator.nextInt(100);
			}
		}
	}
	public void outputResult() {
		System.out.print("Source array: [");
		final String frmtString = (dataType.equals("Integer") ? "%d" : "%.2f");
		for(int i = 0; i < array.length; i++) {
			System.out.printf(Locale.ENGLISH, frmtString + (i + 1 == array.length ? "" : " " ), this.array[i]);
		}
		System.out.println("]");
		//System.out.println("Source array: " + Arrays.toString(this.array));
	}
}