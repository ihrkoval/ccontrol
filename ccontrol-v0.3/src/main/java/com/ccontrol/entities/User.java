package com.ccontrol.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Users")
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
int id;

String login;
String password;
String role;

@OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Phone> phones = new ArrayList<Phone>();



public User(String login, String password, String role) {
	this.login  = login;
	this.password = password;
	this.role = role;
}

public User(){}



@JsonIgnore
public List<Phone> getPhones() {
	return phones;
}

public void setPhones(List<Phone> phones) {
	this.phones = phones;
}

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getId() {
	return id;
}



}
