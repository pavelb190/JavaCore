
package Tasks;

import Tasks.base.ArrayTask_1x1;
import java.util.Locale;


public class ArrMinElement extends ArrayTask_1x1 {
	private Number min = 0;
	private int position = -1;
	public ArrMinElement(final int n, final String dataType) {
		super(n, "Min value and its position.", dataType);
	}
	public Number getMin() {
		
		return this.min;
	}
	public int getPosition() {
		
		return this.position;
	}
	public void performTask() {
		final Object[] arr = getData();
		double min = ((Number)arr[0]).floatValue();
		int position = 0;
		for(int i = 1; i < arr.length; i++) {
			double v = ((Number)arr[i]).floatValue();
			if (min > v) {
				min = v;
				position = i;
			}
		}
		this.min = min;
		this.position = position;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf(Locale.ENGLISH, "Min element: %.2f, in %d position.\n", this.min, this.position);
	}
}