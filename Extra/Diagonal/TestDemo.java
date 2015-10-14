
import java.util.Arrays;

public class TestDemo {
	private static final int[][] srcMatrix;
	private static final int[][] orderedMatrix;
	static {
		srcMatrix = new int[][] {
			{4, 2, 3, 4},
			{1, 2, 3, 4},
			{1, 2, 6, 4},
			{1, 2, 3, 4}
		};
		int n = srcMatrix.length;
		orderedMatrix = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				orderedMatrix[i][j] = srcMatrix[i][j];
			}
		}
	}
	private static int[] orderColumns;
	static {
		orderColumns = new int[srcMatrix.length];
		for(int i = 0; i < orderColumns.length; i++) {
			orderColumns[i] = i;
		}
	}
	public static void main(String[] args) {
		System.out.println("Source Matrix: ");
		showMatrix(srcMatrix);
		System.out.println();
		for(int i = 0; i < srcMatrix.length; i++) {
			orderMatrix(0);
		}
		System.out.println("RESULT: ");
		showMatrix(buildNewMatrix());
		System.out.println("Order of columns: " + Arrays.toString(orderColumns) + ".");
	}
	private static int[][] buildNewMatrix() {
		int n = srcMatrix.length;
		int[][] resMatrix = new int[n][n];
		int k = -1;
		for(int j = 0; j < n; j++) {
			k = orderColumns[j];
			for(int i = 0; i < n; i++) {
				resMatrix[i][j] = srcMatrix[i][k];
			}
		}
		return resMatrix;
	}
	private static void orderMatrix(int n) {
		if (n < orderedMatrix.length - 2) {
			orderMatrix(n + 1);
		}
		if (orderedMatrix[n][n] > orderedMatrix[n + 1][n + 1]) {
			int b = orderedMatrix[n][n];
			orderedMatrix[n][n] = orderedMatrix[n + 1][n + 1];
			orderedMatrix[n + 1][n + 1] = b;
			b = orderColumns[n];
			orderColumns[n] = orderColumns[n + 1];
			orderColumns[n + 1] = b;
		}
	}
	private static void showMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.printf("%d ", m[i][j]);
			}
			System.out.println();
		}
	}
}