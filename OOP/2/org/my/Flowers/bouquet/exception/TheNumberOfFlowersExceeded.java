
package bouquet.exception;

public class TheNumberOfFlowersExceeded extends Exception
{
	private static final String messageInfo = "You have exceeded the number of flowers in the bouquet!";

	public TheNumberOfFlowersExceeded()
	{
		super(messageInfo);
	}
}