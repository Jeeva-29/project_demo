package com.example.springdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DemoEntity {
	
@Id
public int weaponid;
public String weaponname;
public int availablity;
public String location;
public String getweaponname() {
	return weaponname;
}
public void setweaponname(String namee) {
	weaponname = namee;
}
public int getweaponid() {
	return weaponid;
}
public void setweaponid(int objectId) {
	weaponid = objectId;
}
public int getavailablity() {
	return availablity;
}
public void setavailablity(int satellites) {
	availablity = satellites;
}
public String getlocation() {
	return location;
}
public void setlocation(String atmosphere) {
	location = atmosphere;
}



}
