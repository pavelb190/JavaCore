
import java.sql.SQLException;


public interface UserDao {
	
	public void addUser(User newUser) throws SQLException;
	public boolean checkUser(User user) throws SQLException;
	public boolean checkPassword(final String password) throws SQLException;
	public boolean hasRole(final String role) throws SQLException;
}