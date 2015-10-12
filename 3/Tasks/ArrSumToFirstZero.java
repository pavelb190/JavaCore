
package Tasks;

import Tasks.base.ArrayTask_1x1;
import java.util.Locale;


public class ArrSumToFirstZero extends ArrayTask_1x1 {
	private Number sum = 0;
	public ArrSumToFirstZero(final int n, final String dataType) {
		super(n, "Sum to the First \"0\" at array.", dataType);
	}
	public Number getSum() {
		
		return this.sum;
	}
	public void performTask() {
		final Object[] arr = getData();
		int sum = 0;
		for(Object elem : arr) {
			int v = ((Number)elem).intValue();
			if (v != 0) {
				sum += v;
			}
			else {
				
				break;
			}
		}
		this.sum = sum;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf(Locale.ENGLISH, "Sum to the First \"0\" at array: %d.\n", this.sum);
	}
}