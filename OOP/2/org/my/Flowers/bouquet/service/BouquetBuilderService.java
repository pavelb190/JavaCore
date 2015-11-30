
package bouquet.service;

import plants.flower.Flower;

import bouquet.BouquetFlowersBuilder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Locale;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;


public class BouquetBuilderService {

	private List<? extends Flower> flowersAll = null;
	
	private Locale locale = null;

	public BouquetBuilderService(List<? extends Flower> flowers, Locale locale)
	{
		this.flowersAll = flowers;
	}

	private static void printFlowersList(List<? extends Flower> flowers)
	{
		int i = 1;

		for(Flower flower : flowers) {

			System.out.println(i + ": " + flower);

			i++;
		}
	}

	public List<? extends Flower> createBouquet()
	{
		System.out.println("All available flowers (count: " + this.flowersAll.size() + " flower(-s)): "); printFlowersList(this.flowersAll);

		BouquetFlowersBuilder builder = new BouquetFlowersBuilder();

		Scanner in = new Scanner(System.in);

		String _flowersToBeAdded = null;

		System.out.print("\nPlease, select a flowers which will be added to the bouquet (1-" + (this.flowersAll.size()) + " through empty spaces.): ");

		_flowersToBeAdded = in.nextLine();

		String[] flowersIds = _flowersToBeAdded.split(" ");

		//Sort ids in list of flowers ids in its natural order (as integers);
		Arrays.sort(flowersIds, new Comparator<String>() {

			public int compare(String a, String b)
			{
				return (Integer.parseInt(a) - Integer.parseInt(b));
			}
		});

		int i = -1;

		try {

			int k = 0; //i = -1;

			for(String flowerId : flowersIds) {

				i = Integer.parseInt(flowerId) -1 - k;

				builder.addFlower(this.flowersAll.get(i));

				this.flowersAll.remove(i);

				k++;
			}

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}

		System.out.println("\nAvailable flowers (count: " + this.flowersAll.size() + "): "); printFlowersList(this.flowersAll);

		List<? extends Flower> bouquet = builder.getBouquet();

		System.out.println("\nYour bouquet consists of (count: " + bouquet.size() + "): "); printFlowersList(bouquet);

		System.out.println("Confirm? [Y/n]");

		if(!in.next().contains("y")) {

			((List)flowersAll).addAll(bouquet); return null;
		}

		return bouquet;
	}

	public List<? extends Flower> createBouquet(int k)
	{
		// ...

		return this.flowersAll;
	}
}