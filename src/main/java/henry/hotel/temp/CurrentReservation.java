package henry.hotel.temp;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CurrentReservation {
	
	// temp class to filter data and get it from controller to database using services
	//  current reservation fields and annotate to get the required data
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int id;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int stayPeriod;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String room;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int price;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int rooms;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int persons;

	@NotNull(message = "is required")
	@Size(message = "is required")
	private int children;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String openBuffet;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrivalDate;

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private int usertId;

	// current reservation super and fields constructors

	public CurrentReservation() {
	}

	public CurrentReservation(@NotNull(message = "is required") @Size(min = 1, message = "is required") int id,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int stayPeriod,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String room,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int price,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int rooms,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int persons,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int children,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String openBuffet,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") Date arrivalDate,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") int usertId) {
		super();
		this.id = id;
		this.stayPeriod = stayPeriod;
		this.room = room;
		this.price = price;
		this.rooms = rooms;
		this.persons = persons;
		this.children = children;
		this.openBuffet = openBuffet;
		this.arrivalDate = arrivalDate;
		this.usertId = usertId;
	}
	
	// current reservation getters and setters fields

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStayPeriod() {
		return stayPeriod;
	}

	public void setStayPeriod(int stayPeriod) {
		this.stayPeriod = stayPeriod;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getOpenBuffet() {
		return openBuffet;
	}

	public void setOpenBuffet(String openBuffet) {
		this.openBuffet = openBuffet;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getUsertId() {
		return usertId;
	}

	public void setUsertId(int usertId) {
		this.usertId = usertId;
	}

	// override to string method to contain all fields

	@Override
	public String toString() {
		return "CurrentReservation [id=" + id + ", stayPeriod=" + stayPeriod + ", room=" + room + ", price=" + price
				+ ", rooms=" + rooms + ", persons=" + persons + ", children=" + children + ", openBuffet="
				+ openBuffet + ", arrivalDate=" + arrivalDate + ", usertId=" + usertId + "]";
	}

}
