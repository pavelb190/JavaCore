
import plants.flower.room.*;
import plants.flower.garden.*;
import plants.flower.florist.*;

public class TestDemo {
	
	public static void main(String[] args) {
		
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
	}
}