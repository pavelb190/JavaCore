
package plants.flower;

import java.io.Serializable;

import plants.Plant;
import plants.flower.florist.Care;

/**
* Specifies just one kind of plants (Flower).
*/
public abstract class Flower extends Plant implements Serializable {
	
	/**
	* Flower's latin name. 
	*/
	private String latinName;
	
	/**
	* Flower's readable name (for human).
	*/
	protected String title;
	
	/**
	* Type of flower; can be either SHRUB, STALK or CURLY.
	*/
	private FlowerType type;
	
	/**
	* Flower's current freshness level.
	*/
	protected double freshnessLevel = 50;
	
	public Flower(final String latinName, String title, FlowerType type) {
		setLatinName(latinName);
		setTitle(title);
		setType(type);
	}
	
	public String getLatinName() {
		return this.latinName;
	}
	
	public void setLatinName(final String latinName) {
		this.latinName = latinName;
	}
	
	public double getFreshnessLevel() {
		return this.freshnessLevel;
	}
	
	public void setFreshnessLevel(double freshnessLevel) {
		this.freshnessLevel = freshnessLevel;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public FlowerType getType() {
		return this.type;
	}
	
	public void setType(FlowerType type) {
		this.type = type;
	}

	public String toString()
	{
		return "[" + title + " (" + latinName + "): freshness level: " + freshnessLevel + "]";
	}
}