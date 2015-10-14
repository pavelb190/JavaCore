
package Tasks.Extra;

import Tasks.base.ArrayTask_2x2;

public class ArrMakeOrderedDiagonal extends ArrayTask_2x2 {
	
	private boolean success = false;
	private Object[][] orderedMatrix = null;
	
	public ArrMakeOrderedDiagonal(final int n, final String dataType) {
		super(n, n, "Make main diagonal ordered by the columns swapping.", dataType);
	}
	public void performTask() {
	
		this.orderedMatrix = getData();
		
		try {
			
			orderMatrix(0, 0);
		}
		catch(Exception e) {
			
			e.printStackTrace();
			// ...
		}
	}
	private void orderMatrix(int i, int n) throws Exception {
		
		if (i == orderedMatrix.length - 1) {
			
			if (((Number)orderedMatrix[i][i]).intValue() < ((Number)orderedMatrix[n - 1][n - 1]).intValue()) {
				
				throw new Exception("It's not Possible to create a Matrix");
			}
			//success = true;
			
			return ;
		}
		
		int jMin = i;
		//int minPos = orderedMatrix[n][n];
		for(int j = i + 1; j < this.orderedMatrix.length; j++) {
			if (((Number)orderedMatrix[i][jMin]).intValue() > ((Number)orderedMatrix[i][j]).intValue()
					&& ((n > 0) && (((Number)orderedMatrix[i][j]).intValue() >= ((Number)orderedMatrix[n - 1][n - 1]).intValue()))) {
					//&& ((n > 0) && (((Number)orderedMatrix[n - 1][n - 1]).intValue() <= ((Number)orderedMatrix[i][j]).intValue()))) {
				
				
				//jMin = j; break;
			}
		}
		/*
		if ((n > 0) && ((Number)orderedMatrix[i][jMin]).intValue() < ((Number)orderedMatrix[n - 1][n - 1]).intValue()) {
			
			throw new Exception("It's not Possible to create a Matrix!");
		}
		*/
		
		System.out.println("jMin: " + jMin);
		orderMatrix(i + 1, n + 1);
	}
}