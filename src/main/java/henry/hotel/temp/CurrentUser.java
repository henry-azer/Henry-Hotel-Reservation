package henry.hotel.temp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import henry.hotel.validation.FieldMatch;
import henry.hotel.validation.ValidEmail;

// field match annotation for passwords
@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CurrentUser {
	
	// temp class to filter data and get it from controller to database using services
	// current user fields and annotate to get the required data
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String username;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String matchingPassword;
	
	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
	
	// current user super and fields constructors

	public CurrentUser() {

	}

	public CurrentUser(@NotNull(message = "is required") @Size(min = 1, message = "is required") String username,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String password,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String matchingPassword,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String email) {
		this.username = username;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.email = email;
	}
	
	// current user getters and setters fields

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// override to string method to contain all fields

	@Override
	public String toString() {
		return "CurrentUser [username=" + username + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", email=" + email + "]";
	}
	
}

