
package persistent.serialize;

import plants.flower.Flower;

import java.io.IOException;


public interface FlowersSerializer<T extends Flower> {

	public void serialize(T x) throws IOException;
	public Object unserialize() throws IOException, UnserializeClassNotFoundException;
}