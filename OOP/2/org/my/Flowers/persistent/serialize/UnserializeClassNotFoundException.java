
package persistent.serialize;

/**
* Represents an Exception of incorrect casting about unserialized object.
*/
public class UnserializeClassNotFoundException extends Exception {

	/**
	* Custom information message of this exception.
	*/
	private static final String messageInfo = "Certain class not found in unserialize process!";

	public UnserializeClassNotFoundException()
	{
		super(messageInfo);
	}
}