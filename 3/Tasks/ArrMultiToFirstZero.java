
package Tasks;

import Tasks.base.ArrayTask_1x1;
import java.util.Locale;


public class ArrMultiToFirstZero extends ArrayTask_1x1 {
	private Number m = 1;
	public ArrMultiToFirstZero(final int n, final String dataType) {
		super(n, "Multiply to the First \"0\" at array.", dataType);
	}
	public Number getMultiply() {
		
		return this.m;
	}
	public void performTask() {
		final Object[] arr = getData();
		double m = 1;
		for(Object elem : arr) {
			double v = ((Number)elem).doubleValue();
			if (v != 0) {
				m *= v;
			}
			else {
				
				break;
			}
		}
		this.m = m;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf(Locale.ENGLISH, "Multiply to the First \"0\" at array: %.5f.\n", this.m);
	}
}