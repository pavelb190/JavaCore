
package Tasks;

import Tasks.base.ArrayTask_1x1;
import java.util.Locale;


public class ArrNegativeCount extends ArrayTask_1x1 {
	private int count = 0;
	public ArrNegativeCount(final int n, final String dataType) {
		super(n, "Count of negative numbers.", dataType);
	}
	public int getCount() {
		
		return this.count;
	}
	public void performTask() {
		final Object[] arr = getData();
		int count = 0;
		for(Object v : arr) {
			if (((Number)v).floatValue() < 0) {
				count++;
			}
		}
		this.count = count;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf(Locale.ENGLISH, "Count of negative values: %d.\n", this.count);
	}
}