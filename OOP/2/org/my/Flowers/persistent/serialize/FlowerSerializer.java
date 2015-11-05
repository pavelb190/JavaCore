
package persistent.serialize;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import plants.flower.Flower;


public class FlowerSerializer<T extends Flower> implements FlowersSerializer<T> {

	private OutputStream out = null;
	private InputStream in = null;

	private Class<T> clazz;

	public FlowerSerializer(OutputStream out, InputStream in, Class<T> as)
	{
		this.out = out;

		this.in = in;

		this.clazz = as;
	}

	public void serialize(T x) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(this.out);

		out.writeObject(x);

		out.flush();

		out.close();
	}

	//@SuppressWarnings("unchecked")
	public T unserialize() throws IOException, UnserializeClassNotFoundException, ClassCastException
	{
		ObjectInputStream in = new ObjectInputStream(this.in);

		try {

			return clazz.cast(in.readObject());
		}
		catch (ClassNotFoundException e) {

			throw new UnserializeClassNotFoundException();
		}
	}
}