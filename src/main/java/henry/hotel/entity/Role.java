package henry.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`role`")
public class Role {

	// Role fields and annotate with it's column to connect to jpa entity manager
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;

	@Column(name = "role_name")
	private String name;

	// Role super and fields constructors
	
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	// Role getters and setters fields
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// override to string method to contain all fields

	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
