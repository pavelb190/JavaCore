
package service;

import plants.flower.Flower;
import plants.flower.room.*;
import plants.flower.garden.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import persistent.serialize.FlowerSerializer;


public class FlowersDataService {

	public static final String DATA_STORAGE_SRC = "./data.ser";

	public static List<? extends Flower> createFlowersList()
	{
		return new ArrayList<Flower>() {{

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
	}

	public static void persist(List<? extends Flower> flowers) throws IOException, FileNotFoundException
	{
		FlowerSerializer serializer =
			new FlowerSerializer(
				//Save to ..
				new FileOutputStream(DATA_STORAGE_SRC),
					//get from ..
					new FileInputStream(DATA_STORAGE_SRC)
			);

		for(Flower flower : flowers) {

			serializer.serialize(flower);
		}

		serializer.clear();
	}
}