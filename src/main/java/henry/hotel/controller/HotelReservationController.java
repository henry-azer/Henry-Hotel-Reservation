package henry.hotel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import henry.hotel.services.ReservationService;
import henry.hotel.services.UserService;
import henry.hotel.temp.CurrentReservation;
import henry.hotel.temp.CurrentUser;

@Controller
public class HotelReservationController {

	private UserService userService;

	private ReservationService reservationService;
	
	@Autowired
	public HotelReservationController(UserService userService, ReservationService reservationService) {
		this.userService = userService;
		this.reservationService = reservationService;
	}

	// data binder
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	// home page
	@RequestMapping("/")
	public String homePage() {

		return "home-page";
	}

	// login page
	@GetMapping("/login-form-page")
	public String loginPage(Model model) {

		// if user is already login, redirect to home
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		
		// new user attribute for sign up page
		model.addAttribute("newUser", new CurrentUser());

		return "login";
	}

	// registration process page
	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") CurrentUser currentUser,
			BindingResult theBindingResult, Model model) {

		// check the database if user already exists
		if (userService.findUserByEmail(currentUser.getEmail()) != null) {
			model.addAttribute("newUser", new CurrentUser());
			model.addAttribute("registrationError", "Email already exists.");

			return "login";
		}

		// create user account
		userService.saveUser(currentUser);
		model.addAttribute("registrationSuccess", "registration Success.");

		return "redirect:/login-form-page";

	}

	// booking page
	@GetMapping("/new-reservation")
	public String newReservation(Model model) {
		// reservation attribute
		model.addAttribute("newRes", new CurrentReservation());

		return "reservation-page";
	}

	// save new reservation
	@PostMapping("/proceed-reservation")
	public String proceedReservation(@Valid @ModelAttribute("newRes") CurrentReservation currentReservation,
			BindingResult theBindingResult, Model model) {
		
		// send reservation to services to save it in database
		reservationService.saveOrUpdateReservation(currentReservation);

		return "redirect:/your-reservations";
	}

	// reservations of user
	@GetMapping("/your-reservations")
	public String reservationsList(Model model) {
		
		// list of reservations for logged user
		model.addAttribute("resList", reservationService.getReservationsForLoggedUser());

		return "your-reservations";
	}
	
	// update reservation
	@PostMapping("/reservation-update")
	public String updateReservation(@RequestParam("resId") int resId, Model model) {
		
		// new update reservation sent to services to store it in database
		model.addAttribute("newRes", reservationService.reservationToCurrentReservationById(resId));
		
		return "reservation-page";
	}
	

	// delete reservation
	@PostMapping("/reservation-delete")
	public String deleteReservation(@RequestParam("resId") int resId) {
		
		// delete reservation sent to services to delete from database 
		reservationService.deleteReservation(resId);
		
		return "redirect:/your-reservations";
	}
	
	// log out
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		// handle logout for logged user  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login-form-page?logout";
	}

}
