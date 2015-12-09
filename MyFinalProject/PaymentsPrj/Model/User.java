

public class User extends Entity {

	private String firstName;
	private String lastName;

	private String password;

	public String getFirstName() {

		return this.firstName;
	}

	public void setFirstName(final String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return this.lastName;
	}

	public void setLastName(final String lastName) {

		this.lastName = lastName;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}
}