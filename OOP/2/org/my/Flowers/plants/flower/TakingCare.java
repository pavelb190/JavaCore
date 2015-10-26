
package plants.flower;

import plants.flower.florist.Care;

public interface TakingCare<T extends Care> {
	public void takeCare(T care);
}