
package Tasks.base;

import java.util.Scanner;
import java.util.Random;
import java.util.Locale;

public abstract class ArrayTask_2x2 extends ArrayTask {
	private final String dataType;
	private Object[][] array = null;
	public ArrayTask_2x2(final int n, final int m, final String title, final String dataType) {
		super(title);
		this.dataType = dataType;
		this.array = new Object[n][m];
	}
	public ArrayTask_2x2(final int n, final int m, final String dataType) {
		this.dataType = dataType;
		this.array = new Object[n][m];
	}
	public String getType() {
		
		return this.dataType;
	}
	public Object[][] getData() {
		
		return this.array;
	}
	public void inputData() {
		Scanner in = new Scanner(System.in);
		int i, j, m;
		for(i = 0; i < array.length; i++) {
			m = array[i].length;
			for(j = 0; j < m; j++) {
				System.out.printf("Enter a [%d][%d]-element: ", i, j);
				switch (dataType) {
					case "Float": 	this.array[i][j] = in.nextFloat(); break;
					case "Double": 	this.array[i][j] = in.nextDouble(); break;
					case "Integer":
					default: this.array[i][j] = in.nextInt();
				}
			}
		}
	}
	/**
	* Swaps columns by their indexes;
	*/
	private static void swapColumns(Object[][] arr, int a, int b) {
		Object tmp = null;
		for(int i = 0; i < arr[0].length; i++) {
			tmp = arr[i][a];
			arr[i][a] = arr[i][b];
			arr[i][b] = tmp;
		}
	}
	/**
	* Creates a new array copy from source array.
	*/
	private static Object[][] arrayClone(Object[][] arr) {
		Object[][] res = new Object[arr.length][arr[0].length];
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[i].length; j++) {
				res[i][j] = arr[i][j];
			}
		}
		return res;
	}
	/**
	* Creates a new array copy from source array beginning from (i,j) indexes.
	*/
	private static Object[][] arrayClone(Object[][] arr, int ii, int jj) {
		Object[][] res = new Object[arr.length][arr[0].length];
		for(int i = ii; i < res.length; i++) {
			for(int j = jj; j < res[i].length; j++) {
				res[i][j] = arr[i][j];
			}
		}
		return res;
	}
	public void randomInitialize() {
		Random generator = getRandomGenerator();
		int i, j, m;
		for(i = 0; i < array.length; i++) {
			m = array[i].length;
			for(j = 0; j < m; j++) {
				switch (dataType) {
					case "Float": 	this.array[i][j] = generator.nextFloat() * 100; break;
					case "Double": 	this.array[i][j] = generator.nextDouble() * 100; break;
					case "Integer":
					default: this.array[i][j] = generator.nextInt(100);
				}
			}
		}
	}
	public void outputResult() {
		System.out.printf("Source array (%d, %d):\n", array.length, array[0].length);
		final String frmtString = (dataType.equals("Integer") ? "%d " : "%.2f ");
		int i, j, m;
		for(i = 0; i < array.length; i++) {
			m = array[i].length;
			for(j = 0; j < m; j++) {
				System.out.printf(Locale.ENGLISH, frmtString, this.array[i][j]);
			}
			System.out.println();
		}
	}
}