
package bouquet;

import plants.flower.Flower;

import bouquet.exception.TheNumberOfFlowersExceeded;

import java.util.List;
import java.util.LinkedList;

/**
* Helps to collect a bouquet from any flowers.
*/
public class BouquetFlowersBuilder<T extends Flower>
{
	protected List<T> bouquet = null;

	private int size = -1;

	public BouquetFlowersBuilder()
	{
		this.bouquet = new LinkedList<>();
	}

	public BouquetFlowersBuilder(int size)
	{
		this();

		this.size = size;
	}

	public void addFlower(T flower) throws TheNumberOfFlowersExceeded
	{
		if (size > -1 && size < bouquet.size())
		{
			throw new TheNumberOfFlowersExceeded();		//with default message..
		}

		bouquet.add(flower);
	}

	public List<T> getBouquet()
	{
		return this.bouquet;
	}
}

//BouquetFlowersBuilder bouquet = new BouquetFlowersBuilder();

//bouquet.addFlower(new Begoinia());