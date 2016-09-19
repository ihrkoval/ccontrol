package com.ccontrol.DAO;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private EntityManager em; 

	@Override
	public User newUser(String login, String password, String role) {
		em.getTransaction().begin();
		User user = new User(login, password, role);
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	@Override
	public User getUserByName(String login) {
		User u = (User)em.createNativeQuery("Select * from Users where login = '"+login+"'", User.class).getSingleResult();
		
		return u;
	}

}
