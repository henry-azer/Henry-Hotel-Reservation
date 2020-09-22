package henry.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import henry.hotel.entity.User;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	User findByUsername(String username);
}

