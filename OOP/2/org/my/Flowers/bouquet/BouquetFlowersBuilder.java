
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
	private List<T> bouquet = new LinkedList<>();

	private int size = -1;

	public BouquetFlowersBuilder()
	{
		// ... Default constructor ...
	}

	public BouquetFlowersBuilder(int size)
	{
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

	public void clear()
	{
		this.bouquet.clear();
	}

	public List<T> getBouquet()
	{
		return this.bouquet;
	}
}