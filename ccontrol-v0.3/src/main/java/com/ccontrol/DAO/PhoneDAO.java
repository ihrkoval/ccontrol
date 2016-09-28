package com.ccontrol.DAO;

import java.util.List;

import com.ccontrol.entities.Phone;
import com.ccontrol.entities.User;

public interface PhoneDAO {
 public void phoneAdd(Phone p);

List<Phone> getUserPhones(User u);
}
