
package plants.flower.garden;

import plants.flower.FlowerType;

/**
* Represents a kind of roses as flowers.
*/
public class Rose extends GardenFlower {

	/**
	* Contains a flower's name in Latin.
	*/
	public static final String FLOWER_LATIN_NAME = "ROSA";

	/**
	* Contains a kind of flower's name which is understandable for user.
	*/
	public static final String FLOWER_TITLE = "Rose";

	public Rose() {
		super(FLOWER_LATIN_NAME, FLOWER_TITLE, FlowerType.STALK);
	}
}