
package persistent.serialize;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import plants.flower.Flower;


public class FlowerSerializer implements FlowersSerializer<?> {

	private OutputStream out = null;
	private InputStream in = null;

	public FlowerSerializer(OutputStream out, InputStream in)
	{
		this.out = out;

		this.in = in;
	}

	public void serialize(? x) throws IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(this.out);

		out.writeObject(x);

		out.flush();

		out.close();
	}

	public Flower unserialize() throws IOException
	{
		ObjectInputStream in = new ObjectInputStream(this.in);

		//System.out.println();

		return (plants.flower.room.Begonia)in.readObject();
	}
}