
package plants.flower.florist;

public class ToWaterFlowers extends Care {
	
	/**
	* Water amount for watering.
	*/
	private int waterAmount;
	
	public ToWaterFlowers(int waterAmount) {
		this.waterAmount = waterAmount;
	}
	
	public int getWater() {
		return waterAmount;
	}
}