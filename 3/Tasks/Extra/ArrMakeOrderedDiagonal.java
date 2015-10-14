
package Tasks.Extra;

import java.util.Arrays;
import Tasks.base.ArrayTask_2x2;

public class ArrMakeOrderedDiagonal extends ArrayTask_2x2 {
	
	private boolean success = false;
	private Object[][] orderedMatrix = null;
	
	public ArrMakeOrderedDiagonal(final int n, final String dataType) {
		super(n, n, "Make main diagonal ordered by the columns swapping.", dataType);
	}
	public void performTask() {
	
		this.orderedMatrix = getData();
		
		//swapColumns(orderedMatrix, 1, 2);
		//this.orderedMatrix = arrayClone(orderedMatrix, 2, 2);
		
		//printArray(this.orderedMatrix, "Integer");
	}
	private static boolean orderMatrix(Object[][] arr, int n) {
		
	}
}