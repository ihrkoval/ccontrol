package com.ccontrol.DAO;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public User newUser(String login, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Autowired
    private EntityManager em; 
*/
	/*@Override
	public User newUser(String login, String password, String role) {
		
		User user = new User(login, password, role);
		try{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		return new User();
	}

	@Override
	public User getUserByName(String login) {
		//User u = (User)em.createNativeQuery("Select * from Users where login = '"+login+"'", User.class).getSingleResult();
		User u = new User();
		u.setLogin(login);
		return u;
	}
	
	@Override
	public User getUserByID(int id) {
		User u = (User)em.createNativeQuery("Select * from Users where id = '"+id+"'", User.class).getSingleResult();
		
		return new User();
	}*/

}
