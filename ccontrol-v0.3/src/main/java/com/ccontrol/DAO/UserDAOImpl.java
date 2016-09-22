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
		
		User user = new User(login, password, role);
		try{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		return user;
	}

	@Override
	public User getUserByName(String login) {
		System.out.println( " try to get user from SQL ...");
		User u = (User)em.createNativeQuery("Select * from Users where login = '"+login+"'", User.class).getSingleResult();
		System.out.println(u.getLogin() + " USERNAME in UeserIMPL from DB");
		return u;
	}
	
	@Override
	public User getUserByID(int id) {
		User u = (User)em.createNativeQuery("Select * from Users where id = '"+id+"'", User.class).getSingleResult();
		
		return u;
	}

}
