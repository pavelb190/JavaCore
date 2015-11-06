
package service;

import plants.flower.Flower;
import plants.flower.room.*;
import plants.flower.garden.*;

import java.util.List;
import java.util.ArrayList;


public class FlowersDataService {

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
}