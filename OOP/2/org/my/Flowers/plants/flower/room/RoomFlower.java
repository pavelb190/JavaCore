
package plants.flower.room;

import java.lang.Math;

import java.util.Random;

import plants.flower.Flower;
import plants.flower.FlowerType;
import plants.flower.TakingCare;
//import plants.flower.florist.Care;
import plants.flower.florist.ToWaterFlowers;

/**
* Specifies only the room flowers kind.
*/
public abstract class RoomFlower extends Flower implements TakingCare<ToWaterFlowers> {
	
	private static Random rGenerator = new Random();

	private int dailyRateMoisture;
	private int currentMoistureAmount = 0;
	
	/**
	* @param dailyRateMoisture contains a daily rate of water needed for flower's normal growth.
	*/
	public RoomFlower(final String latinName, String title, FlowerType type, int dailyRateMoisture) {
		super(latinName, title, type);
		setDailyRateMoisture(dailyRateMoisture);
	}
	
	public void run()
	{
		takeCare(new ToWaterFlowers(rGenerator.nextInt(dailyRateMoisture * 3 + 1)));

		try {

			Thread.sleep(650);
		}
		catch (InterruptedException e) {

			e.printStackTrace();

			// ...
		}
		grow();
	}

	public void takeCare(ToWaterFlowers care) {
		this.currentMoistureAmount += care.getWater();
		//setCurrentMoistureAmount(getCurrentMoistureAmount(care.getWater()));
	}
	
	/**
	* Absorbs moisture, grows up and updates the freshness level. ;)
	*/
	public void grow() {

		currentMoistureAmount -= dailyRateMoisture;

		double tPercent = (double)(currentMoistureAmount * 100 / dailyRateMoisture);

		setFreshnessLevel(100 - Math.abs(tPercent));
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