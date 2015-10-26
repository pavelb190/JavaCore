
public class TestDemo {
	
	public static void main(String[] args) {
		
		plants.flower.room.Begonia begonia = new plants.flower.room.Begonia();
		
		System.out.println(begonia.getFreshnessLevel());

		begonia.takeCare(new plants.flower.florist.ToWaterFlowers(450));
		
		begonia.grow();
		
		begonia.takeCare(new plants.flower.florist.ToWaterFlowers(450));

		begonia.grow();

		System.out.println(begonia.getFreshnessLevel());
		
		plants.flower.garden.Rose rose = new plants.flower.garden.Rose();

		rose.grow();
		rose.grow();
		//rose.grow();

		rose.takeCare(new plants.flower.florist.ToWeedGrass(5));

		System.out.println(rose.getFreshnessLevel());
	}
}