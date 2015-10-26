
package plants.flower.garden;

import plants.flower.Flower;
import plants.flower.FlowerType;

/**
* Specifies only the garden flowers kind.
*/
public class GardenFlower extends Flower {
	
	public GardenFlower(final String latinName, String title, FlowerType type) {
		super(latinName, title, type);
	}
}