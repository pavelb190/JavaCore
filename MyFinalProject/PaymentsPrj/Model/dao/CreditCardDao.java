
import java.sql.SQLException;


public interface CreditCardDao {

	public void addCreditCard(final CreditCard creditCard) throws SQLException;
	public CreditCard getCreditCardById(final long creditCardId) throws SQLException;
	public List<CreditCard> getCreditCardsForAccount(BankAccount account) throws SQLException;

	// ...
}