package com.ccontrol.DAO;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.Phone;


@Repository
public class PhoneDAOImpl implements PhoneDAO {

	@Autowired
    private EntityManager em; 

	
	@Override
	public void phoneAdd(Phone p) {
		try{
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		}
		
	}

}
