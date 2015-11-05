
package plants.flower.room;

import plants.flower.FlowerType;

/**
* Represents a kind of begonias as flowers.
*/
public class Begonia extends RoomFlower {

	/**
	* Contains a flower's name in latin.
	*/
	public static final String FLOWER_LATIN_NAME = "BEGONIA";

	/**
	* Contains a kind of flower's name which is understandable for user.
	*/
	public static final String FLOWER_TITLE = "Begonia";

	public Begonia() {
		super(FLOWER_LATIN_NAME, FLOWER_TITLE, FlowerType.SHRUB, 250);
	}
}