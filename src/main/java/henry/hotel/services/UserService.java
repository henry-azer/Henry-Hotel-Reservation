package henry.hotel.services;

import henry.hotel.entity.User;
import henry.hotel.temp.CurrentUser;

import org.springframework.security.core.userdetails.UserDetailsService;

//Service Pattern for User
public interface UserService extends UserDetailsService {

	public User findUserByEmail(String email);

	public void saveUser(CurrentUser currentUser);

	public int getLoggedUserId();
}
