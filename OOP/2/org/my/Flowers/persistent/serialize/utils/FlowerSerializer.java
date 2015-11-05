
package persistent.serialize.utils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import plants.flower.Flower;

import persistent.serialize.FlowersSerializer;


public class FlowerSerializer implements FlowersSerializer<Flower> {

	public static byte[] serialize(Flower x, OutputStream out)
	{
		ObjectOutputStream output = new ObjectOutputStream(out);

		// ...
	}

	public static Flower unserialize(byte[] src, InputStream in)
	{
		// ...
	}
}