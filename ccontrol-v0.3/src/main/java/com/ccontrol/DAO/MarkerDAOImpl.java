package com.ccontrol.DAO;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.Marker;


@Repository
public class MarkerDAOImpl implements MarkerDAO {
	
	@Autowired
    private EntityManager em; 

	@Override
	public void addMarker(Marker m) {
		try{
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			} catch (Exception e){
				em.getTransaction().rollback();
			}
		
	}

}
