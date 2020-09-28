package henry.hotel.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import henry.hotel.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	// dao pattern to deal with retrieve and send data to and from database for user

	// field injection entity manager
	@Autowired
	private EntityManager entityManager;

	// get user from database with email
	@Override
	public User findUserByEmail(String email) {
		
		// create query with HQL to get user
		Query<User> query = currentSession().createQuery("from User where user_email=:uEmail", User.class);
		query.setParameter("uEmail", email);

		// check if valid user and is exist or null
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}
		
	// get user from databasr using username 
	@Override
	public User findUserByUsername(String username) {
		
		// create query with HQL to get user
		Query<User> query = currentSession().createQuery("from User where user_username=:uName", User.class);
		query.setParameter("uName", username);

		// check if valid user and is exist or null
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}

		return user;
	}
	
	// create user and update if is exist
	@Override
	public void saveUser(User theUser) {
		currentSession().saveOrUpdate(theUser);
	}

	// get current hibernate session
	private Session currentSession() {
		return entityManager.unwrap(Session.class);
	}
}
