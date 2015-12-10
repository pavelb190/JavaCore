

public class UserDaoImpl implements UserDao {

	private Connection cn = null;

	public UserDaoImpl(Connection conn) {

		this.cn = conn;
	}

	public void addUser(final User newUser)
		throws SQLException {

		// ...
	}

	public User getUserById(final long userId)
		throws SQLException {

		final String SQL_STR = "SELECT * FROM Users WHERE id = ?";

		// ...
	}

	public User getUserByEmail(final String email)
		throws SQLException {

		final String SQL_STR = "SELECT * FROM Users WHERE name = ?";

		// ...
	}

	public boolean checkUser(User user)
		throws SQLException {

		final String SQL_STR = "SELECT * FROM Users WHERE id = ? AND password = ?";

		// ...
	}

	public boolean checkPassword(final String password)
		throws SQLException {

		// ...
	}

	public boolean hasRole(final String role)
		throws SQLException {

		// ...
	}
}