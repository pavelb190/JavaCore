
package Tasks;

import Tasks.base.ArrayTask_1x1;


public class ArrZeroAppend extends ArrayTask_1x1 {
	private Object[] resArr = null;
	public ArrZeroAppend(final int n, final String dataType) {
		super(n, "Append all Zeros to the end.", dataType);
	}
	public void performTask() {
		Object[] arr = getData();
		for(int i = 0; i < arr.length; i++) {
			float v = ((Number)arr[i]).floatValue();
			if (v == 0) {
				for(int j = i; j < arr.length - 1; j++) {
					arr[j] = arr[j + 1];
				}
				arr[arr.length - 1] = v;
				if (!endsWithZeros(arr, i)) {
					i--;
				}
			}
		}
		this.resArr = arr;
	}
	private boolean endsWithZeros(Object[] arr, int fromPos) {
		for(int i = fromPos; i < arr.length; i++) {
			if (((Number)arr[i]).floatValue() != 0) {
				
				return false;
			}
		}
		return true;
	}
}