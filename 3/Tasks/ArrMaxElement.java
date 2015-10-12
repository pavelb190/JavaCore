
package Tasks;

import Tasks.base.ArrayTask_1x1;
import java.util.Locale;


public class ArrMaxElement extends ArrayTask_1x1 {
	private Number max = 0;
	private int position = -1;
	public ArrMaxElement(final int n, final String dataType) {
		super(n, "Max value and its position.", dataType);
	}
	public Number getMax() {
		
		return this.max;
	}
	public int getPosition() {
		
		return this.position;
	}
	public void performTask() {
		final Object[] arr = getData();
		float max = ((Number)arr[0]).floatValue();
		int position = 0;
		for(int i = 1; i < arr.length; i++) {
			float v = ((Number)arr[i]).floatValue();
			if (max < v) {
				max = v;
				position = i;
			}
		}
		this.max = max;
		this.position = position;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf(Locale.ENGLISH, "Max element: %.2f, in %d position.\n", this.max, this.position);
	}
}