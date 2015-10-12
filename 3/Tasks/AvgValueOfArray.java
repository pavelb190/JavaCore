
package Tasks;

import Tasks.base.ArrayTask_1x1;


public class AvgValueOfArray extends ArrayTask_1x1 {
	private double avg = 0;
	public AvgValueOfArray(final int n, final String dataType) {
		super(n, "The Average value of array.", dataType);
	}
	public double getAvg() {
		
		return this.avg;
	}
	public void performTask() {
		final Object[] arr = getData();
		float sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += ((Number)arr[i]).floatValue();
		}
		this.avg = sum / arr.length;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf("Average value = %f\n", this.avg);
	}
}