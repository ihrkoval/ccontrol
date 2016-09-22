package com.ccontrol.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccontrol.entities.Marker;
import com.ccontrol.entities.Phone;


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
	
	@Override
	public List<Marker> getMarkers(Phone p, Date d){
		return (List<Marker>)em.createNativeQuery("select * from Markers where phone_id = "+p.getId(), Marker.class).getResultList();
	}

}
