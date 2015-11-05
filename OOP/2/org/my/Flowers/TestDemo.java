
import plants.flower.Flower;

import plants.flower.room.*;
import plants.flower.garden.*;
import plants.flower.florist.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Map;
import java.util.HashMap;

import bouquet.BouquetFlowersBuilder;


public class TestDemo {

	/**
	* Can be loaded from an external source*. (later)
	*/
	/*
	private static List<?> flowersAll = new ArrayList<Flower>() {{
		
		//Begonias:
		add(new Begonia());
		add(new Begonia());
		add(new Begonia());
		
		//Chamomiles:
		add(new Chamomile());
		add(new Chamomile());
		add(new Chamomile());

		//Roses:
		add(new Rose());
		add(new Rose());
		add(new Rose());
		add(new Rose());
	}};
	*/

	//private Map<String, List<? extends Flower>> flowersAll = new HashMap<String, List<Flower>>();

	public static void main(String[] args) {
		
		try {
		
			persistent.serialize.FlowerSerializer serializer = new persistent.serialize.FlowerSerializer(
					//System.out, System.in
					new java.io.FileOutputStream("temp.out"), new java.io.FileInputStream("temp.out")
				);

			serializer.serialize(new Begonia());

			Begonia a = serializer.unserialize();

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}

		//BouquetFlowersBuilder bouquet = new BouquetFlowersBuilder();

		/*
		try {

			bouquet.addFlower(new Begonia());
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		*/

		//System.out.println('Count: ' + bouquet.getBouquet().size());
		/*
		Begonia begonia = new plants.flower.room.Begonia();
		
		System.out.println(begonia.getFreshnessLevel());

		begonia.takeCare(new ToWaterFlowers(450));
		
		begonia.grow();
		
		begonia.takeCare(new ToWaterFlowers(450));

		begonia.grow();

		System.out.println(begonia.getFreshnessLevel());
		
		Rose rose = new Rose();

		rose.grow();
		rose.grow();
		//rose.grow();

		rose.takeCare(new ToWeedGrass(5));

		System.out.println(rose.getFreshnessLevel());
		*/
	}
}