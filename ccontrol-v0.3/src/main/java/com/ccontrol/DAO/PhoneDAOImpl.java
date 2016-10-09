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
	public Phone phoneAdd(Phone p) {
		Phone newPhone = new Phone(p.getUser(), p.getEmei(), p.getName());
		try{
		em.getTransaction().begin();
		em.persist(newPhone);
		em.getTransaction().commit();
		return newPhone;
		} catch (Exception e){
			em.getTransaction().rollback();
		}
	return new Phone();
	}
	
	
	@Override
	public List<Phone> getUserPhones(User u){
		em.getTransaction().begin();
		Query phones =  em.createNativeQuery("select * from Phones where user_id="+u.getId(), Phone.class);
		em.getTransaction().commit();
		return (List<Phone>) phones.getResultList();
		
	}




}
