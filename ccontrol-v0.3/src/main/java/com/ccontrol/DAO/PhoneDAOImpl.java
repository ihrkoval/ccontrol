package com.ccontrol.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.Phone;
import com.ccontrol.entities.User;


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
	
	
	@Override
	public List<Phone> getUserPhones(User u){
		
		Query phones =  em.createNativeQuery("select * from Phones where user_id="+u.getId(), Phone.class);
		return (List<Phone>) phones.getResultList();
		
	}




}
