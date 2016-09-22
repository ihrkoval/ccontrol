package com.ccontrol.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Phones")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user;
	
	@OneToMany(mappedBy="phone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Marker> markers = new ArrayList<Marker>();
	

	String emei;
	String name;
	
	public Phone(){}
	
	
	
	public Phone(User user, String emei, String name) {
		super();
		this.user = user;
		this.emei = emei;
		this.name = name;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Marker> getMarkers() {
		return markers;
	}
	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}
	public String getEmei() {
		return emei;
	}
	public void setEmei(String emei) {
		this.emei = emei;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
