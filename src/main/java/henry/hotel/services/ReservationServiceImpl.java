package henry.hotel.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henry.hotel.entity.Reservation;
import henry.hotel.repository.ReservationRep;
import henry.hotel.temp.CurrentReservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	// service pattern to manage transactionals  
	//	and handle services for reservation between server and client
	
	private UserService userService;

	private ReservationRep reservationRepository;
	
	@Autowired
	public ReservationServiceImpl(UserService userService, ReservationRep reservationRepository) {
		this.userService = userService;
		this.reservationRepository = reservationRepository;
	}
	
	// get reservation for logged user
	@Override
	@Transactional
	public Reservation getReservationForLoggedUserById(int resId) {
		
		return reservationRepository.findById(resId);
	}

	// get all reservations for logger user 
	@Override
	@Transactional
	public Collection<Reservation> getReservationsForLoggedUser() {
		return reservationRepository.findAllByUserId((userService.getLoggedUserId()));
	}

	// transfer data between temp reservation and Reservation class after check it to save it 
	@Override
	@Transactional
	public void saveOrUpdateReservation(CurrentReservation currentReservation) {
		Reservation reservation = new Reservation();

		// get required id user using user services
		reservation.setUserId(userService.getLoggedUserId());

		reservation.setArrivalDate(currentReservation.getArrivalDate());
		reservation.setOpenBuffet(currentReservation.getOpenBuffet());
		reservation.setStayDays(currentReservation.getStayPeriod());
		reservation.setChildren(currentReservation.getChildren());
		reservation.setPersons(currentReservation.getPersons());
		reservation.setPrice(currentReservation.getPrice());
		reservation.setRooms(currentReservation.getRooms());
		reservation.setRoom(currentReservation.getRoom());
		reservation.setId(currentReservation.getId());

		reservationRepository.save(reservation);
	}
	
	// transfer data between Reservation and temp Reservation class to update request  
	@Override
	public CurrentReservation reservationToCurrentReservationById(int resId) {
		Reservation reservation = getReservationForLoggedUserById(resId);
		CurrentReservation currentReservation = new CurrentReservation();
		
		currentReservation.setArrivalDate(reservation.getArrivalDate());
		currentReservation.setOpenBuffet(reservation.getOpenBuffet());
		currentReservation.setStayPeriod(reservation.getStayDays());
		currentReservation.setChildren(reservation.getChildren());
		currentReservation.setPersons(reservation.getPersons());
		currentReservation.setUsertId(reservation.getUserId());
		currentReservation.setRooms(reservation.getRooms());
		currentReservation.setPrice(reservation.getPrice());
		currentReservation.setRoom(reservation.getRoom());
		currentReservation.setId(reservation.getId());
		
		return currentReservation;
	}
	
	// delete reservation 
	@Override
	@Transactional
	public void deleteReservation(int resId) {
		
		reservationRepository.deleteById(resId);
	}
}
