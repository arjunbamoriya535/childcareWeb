package com.childcare.bean;

import java.awt.Image;
import java.sql.Blob;

public class Baby {
int id;
  Blob imageData;


String name,meaning,sex,religion,race,imageFileName,city,phone;
public String getCity() {
	return city;
}
public String getPhone() {
	return phone;
}
public void setCity(String city) {
	this.city=city;
}
public Blob getImageData() {
    return imageData;
}

public void setImageData(Blob blob) {
    this.imageData = blob;
}
public void setPhone(String phone) {
	this.phone=phone;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRace() {
	return race;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMeaning() {
	return meaning;
}
public void setMeaning(String meaning) {
	this.meaning = meaning;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public void setRace1(String race) {
	// TODO Auto-generated method stub
	this.race = race;
	
}
public void setRace(String race) {
	// TODO Auto-generated method stub
	this.race = race;
}
public String getImageFileName() {
	return imageFileName;
}
public void setImageFileName(String imageFileName) {
	this.imageFileName = imageFileName;
}

}
