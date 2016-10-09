package com.ccontrol.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Markers")
public class Marker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	Phone phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user;
	
	String lat;
	String lng;
	Date timestamp;
	Timestamp time;
	
	public Marker(){}
	
	public Marker(Phone phone, String lat, String lng, Date timestamp, Timestamp time) {
		super();
		this.time = time;
		this.phone = phone;
		this.lat = lat;
		this.lng = lng;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}
	
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = Timestamp.valueOf(time);
	}
	
	

}
