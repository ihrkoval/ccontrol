package com.ccontrol.DAO;

import java.sql.Date;
import java.util.List;

import com.ccontrol.entities.Marker;
import com.ccontrol.entities.Phone;

public interface MarkerDAO {
void addMarker(Marker m);
public List<Marker> getMarkers(Phone p, Date d);
}
