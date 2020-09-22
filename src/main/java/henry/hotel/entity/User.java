package henry.hotel.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`user`")
public class User {

	// User fields and annotate with it's column to connect to jpa entity manager
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "user_username")
	private String username;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reservation_user_id")
	private Collection<Reservation> reservations;

	// User super and fields constructors

	public User() {
	}

	public User(String userName, String password, String email, Collection<Role> roles, Collection<Reservation> reservations) {
		this.username = userName;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.reservations = reservations;
	}

	// User getters and setters fields

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Role> getRoles() {		
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		Collection<Role> roles1 = new ArrayList<>();
		roles1.add(new Role("ROLE_EMPLOYEE"));
		
		this.roles = roles1;
	}
	
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	// override to string method to contain all fields

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", password=" + password + ", email=" + email + ", roles="
				+ roles + ", reservations=" + reservations + "]";
	}

}

