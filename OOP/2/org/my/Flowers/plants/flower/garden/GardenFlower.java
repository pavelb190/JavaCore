
package plants.flower.garden;

import plants.flower.Flower;
import plants.flower.FlowerType;
import plants.flower.TakingCare;
import plants.flower.florist.ToWeedGrass;

/**
* Specifies only the garden flowers kind.
*/
public class GardenFlower extends Flower implements TakingCare<ToWeedGrass> {
	
	private int weedAmount = 0;

	public GardenFlower(final String latinName, String title, FlowerType type) {
		super(latinName, title, type);
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