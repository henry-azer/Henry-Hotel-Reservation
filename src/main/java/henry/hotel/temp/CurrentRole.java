package henry.hotel.temp;

public class CurrentRole {
	// unused class
	
	private Long id;
	
	private String name;


	public CurrentRole() {
		super();
	}

	public CurrentRole(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "CurrentRole [id=" + id + ", name=" + name + "]";
	}

}
