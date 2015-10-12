
class ArrMinMaxValue extends ArrayTask_1x1 {
	private int min = 0;
	private int max = 0;
	public ArrMinMaxValue(final int n, final String dataType) {
		super(n, "Min & max values of array.", dataType);
	}
	public int getMin() {
		
		return this.min;
	}
	public int getMax() {
		
		return this.max;
	}
	public void performTask() {
		final Object[] arr = getData();
		int v = ((Number)arr[0]).intValue();
		int min = v;
		int max = v;
		for(int i = 1; i < arr.length; i++) {
			v = ((Number)arr[i]).intValue();
			if (min > v) {
				min = v;
			}
			if (max < v) {
				max = v;
			}
		}
		this.min = min;
		this.max = max;
	}
	public void outputResult() {
		super.outputResult();
		System.out.printf("Min value = %d\n", this.min);
		System.out.printf("Max value = %d\n", this.max);
	}
}