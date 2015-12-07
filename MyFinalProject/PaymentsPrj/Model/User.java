

public class User extends Entity {

	private String name;
	private String password;

	public String getName() {

		return this.name;
	}

	public void setName(final String name) {

		this.name = name;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}
}