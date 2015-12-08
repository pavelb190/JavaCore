
import java.sql.SQLException;


public interface TransactionDao {

	public void addTransaction(Transaction transaction) throws SQLException;
}