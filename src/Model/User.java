package Model;

public class User {
	private String email;
	private String password;
	private String username;
	private String name;
	private String role;
	private String phone;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String email, String password, String username, String name, String role, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
		this.role = role;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", username=" + username + ", name=" + name
				+ ", role=" + role + ", phone=" + phone + "]";
	}
	

}
