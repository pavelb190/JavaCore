
import plants.flower.Flower;

import plants.flower.room.*;
import plants.flower.garden.*;
import plants.flower.florist.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

import bouquet.BouquetFlowersBuilder;

import service.FlowersDataService;

import bouquet.service.BouquetBuilderService;


public class TestDemo {

	/**
	* List of all available flowers in app.
	*/
	private static List<? extends Flower> flowers = FlowersDataService.createFlowersList();

	public static void main(String[] args) {

		Locale locale = null;

		if (args.length > 0) {

			locale = new Locale(args[0]);
		}
		else {

			locale = new Locale("ru", "RU");
		}

		bouquet.service.BouquetBuilderService bouquetService = new bouquet.service.BouquetBuilderService(flowers, locale);

		List<? extends Flower> bouquet = bouquetService.createBouquet();

		try {

			FlowersDataService.persist(flowers);

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}

		//System.out.println("Bouquet size: " + bouquet.size());
		//System.out.println("Flowers count: " + flowers.size());

		/*
		Begonia begonia = new Begonia();
		Rose rose = new Rose();

		System.out.println("Begonia current freshness level is: " + begonia.getFreshnessLevel());
		System.out.println("Rose current freshness level is: " + rose.getFreshnessLevel());

		begonia.takeCare(new ToWaterFlowers(250));

		begonia.grow();
		rose.grow();

		System.out.println("Begonia current freshness level is: " + begonia.getFreshnessLevel());
		System.out.println("Rose current freshness level is: " + rose.getFreshnessLevel());

		try {
		
			FlowerSerializer<Flower> serializer = new FlowerSerializer<>(
					//System.out, System.in
					new java.io.FileOutputStream("temp.out"), new java.io.FileInputStream("temp.out") //, Begonia.class
				);

			serializer.serialize(begonia);
			serializer.serialize(rose);

			Flower a = (Begonia)serializer.unserialize();
			Flower b = (Rose)serializer.unserialize();

			System.out.println(a.getFreshnessLevel() + " " + b.getFreshnessLevel());

			//System.out.println(a.getClass().getName() + " " + b.getClass().getName());

			serializer.clear();

		} catch (Exception e) {

			e.printStackTrace();

			// ...
		}
		*/

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