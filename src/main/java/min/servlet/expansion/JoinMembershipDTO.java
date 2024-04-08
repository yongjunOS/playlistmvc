package min.servlet.expansion;

public class JoinMembershipDTO {
	private String name;
	private String id;
	private String password;
	private String gender;
	private String hobby;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "JoinMembershipDTO [name=" + name + ", id=" + id + ", password=" + password + ", gender=" + gender
				+ ", hobby=" + hobby + "]";
	}

}
