
package bouquet.service;

import plants.flower.Flower;

import java.util.List;


public class BouquetBuilderService {

	private List<? extends Flower> flowersAll = null;

	public BouquetBuilderService(List<? extends Flower> flowers)
	{
		this.flowersAll = flowers;
	}

	public List<? extends Flower> createBouquet()
	{
		// ...
	}

	public List<? extends Flower> createBouquet(int size)
	{
		// ...
	}
}