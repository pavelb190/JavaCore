
import java.sql.SQLException;


public interface UserDao {
	
	public void addUser(final User newUser) throws SQLException;
	public User getUserById(final long userId) throws SQLException;
	public User getUserByEmail(final String email) throws SQLException;
	public boolean checkUser(User user) throws SQLException;
	public boolean checkPassword(final User user, final String password) throws SQLException;
	public boolean hasRole(final String role) throws SQLException;
}