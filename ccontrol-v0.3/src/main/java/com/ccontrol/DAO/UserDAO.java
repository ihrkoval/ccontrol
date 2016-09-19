package com.ccontrol.DAO;

import com.ccontrol.entities.User;


public interface UserDAO {
public User newUser(String login, String password, String role);
public User getUserByName(String login);
}
