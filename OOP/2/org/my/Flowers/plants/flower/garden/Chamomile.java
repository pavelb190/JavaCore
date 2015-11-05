
package plants.flower.garden;

import plants.flower.FlowerType;

/**
* Represents a kind of chamomiles as flowers.
*/
public class Chamomile extends GardenFlower
{
	/**
	* Contains a flower's name in Latin.
	*/
	public static final String FLOWER_LATIN_NAME = "CHAMOMILLA RECUTITA";

	/**
	* Contains a kind of flower's name which is understandable for user.
	*/
	public static final String FLOWER_TITLE = "Chamomile";

	public Chamomile()
	{
		super(FLOWER_LATIN_NAME, FLOWER_TITLE, FlowerType.STALK);
	}
}