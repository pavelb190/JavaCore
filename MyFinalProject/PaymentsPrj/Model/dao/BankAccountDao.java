
import java.sql.SQLException;


public interface BankAccountDao {

	public void createAccountForUser(BankAccount account, User user) throws SQLException;
	public void accountUpdate(BankAccount account) throws SQLException;
	public void accountLock(BankAccount account) throws SQLException;
	public void accountUnlock(BankAccount account) throws SQLException;
	public boolean accountIsAvailable(BankAccount account) throws SQLException;
}