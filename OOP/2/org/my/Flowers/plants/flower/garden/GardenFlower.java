
package plants.flower.garden;

import plants.flower.Flower;
import plants.flower.FlowerType;
import plants.flower.TakingCare;
import plants.flower.florist.ToWeedGrass;

import java.util.Random;

/**
* Specifies only the garden flowers kind.
*/
public class GardenFlower extends Flower implements TakingCare<ToWeedGrass> {
	
	private static Random rGenerator = new Random();

	private int weedAmount = 0;

	public GardenFlower(final String latinName, String title, FlowerType type) {
		super(latinName, title, type);
	}

	public void run()
	{
		takeCare(new ToWeedGrass(rGenerator.nextInt(10) + 1));

		try {

			Thread.sleep(750);
		}
		catch (InterruptedException e) {

			e.printStackTrace();

			// ...
		}
		grow();
	}

	public void takeCare(ToWeedGrass care) {
		
		int amount = care.getAmount();

		weedAmount = amount > weedAmount ? 0 : weedAmount - amount;

		double currentFreshnessLevel = getFreshnessLevel() + amount;

		setFreshnessLevel(currentFreshnessLevel);
	}

	public void grow() {
		
		weedAmount += 2;

		double currentFreshnessLevel = getFreshnessLevel() - weedAmount;

		setFreshnessLevel(currentFreshnessLevel);
	}
}