

public class Task8 {

	private static final int[][] srcMatrix;
	
	static {
		srcMatrix = new int[][]{
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 0},
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 0}
		};
	};
	
	public static void main(String[] args) throws Exception {
		if (args.length == 2) {
			transformMatrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
			printMatrix(srcMatrix);
		}
		else {
			
			throw new Exception("N, M params are not specified!");
		}
	}
	private static void transformMatrix(int n, int m) {
		if (srcMatrix[n][m] == 0) {
			for(int i = 0; i < srcMatrix.length; i++) {
				srcMatrix[i][m] = 0;
			}
			for(int j = 0; j < srcMatrix[n].length; j++) {
				srcMatrix[n][j] = 0;
			}
		}
	}
	private static void printMatrix(final int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				System.out.printf("%d\t", m[i][j]);
			}
			System.out.println();
		}
	}
}