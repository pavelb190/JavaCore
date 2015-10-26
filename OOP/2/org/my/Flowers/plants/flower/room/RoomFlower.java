
package plants.flower.room;

import plants.flower.Flower;
import plants.flower.FlowerType;
import plants.flower.florist.Care;
import plants.flower.florist.ToWaterFlowers;

/**
* Specifies only the room flowers kind.
*/
public abstract class RoomFlower extends Flower {
	
	private int dailyRateMoisture;
	private int currentMoistureAmount = 0;
	
	/**
	* @param dailyRateMoisture contains a daily rate of water needed for flower's normal growth.
	*/
	public RoomFlower(final String latinName, String title, FlowerType type, int dailyRateMoisture) {
		super(latinName, title, type);
		setDailyRateMoisture(dailyRateMoisture);
	}
	
	public void takeCare(ToWaterFlowers care) {
		this.currentMoistureAmount += care.getWater();
		//setCurrentMoistureAmount(getCurrentMoistureAmount(care.getWater()));
	}
	
	public int getCurrentMoistureAmount() {
		return currentMoistureAmount;
	}
	
	public void setCurrentMoistureAmount(int moistureAmount) {
		this.currentMoistureAmount = moistureAmount;
	}
	
	public int getDailyRateMoisture() {
		return dailyRateMoisture;
	}
	
	public void setDailyRateMoisture(int dailyRateMoisture) {
		this.dailyRateMoisture = dailyRateMoisture;
	}
}