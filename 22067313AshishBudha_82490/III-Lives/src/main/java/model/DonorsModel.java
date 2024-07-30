package model;

import java.time.LocalDate;

public class DonorsModel {
	private String first_name;
	private String last_name;
	private LocalDate birthday;
	private String username;
	private String password;
	private String email;
	private String city;
	private String blood_type;
	private String disease;
	private String blood_centre;
	
	
	public DonorsModel() 
	{
	}
	
	public DonorsModel(String first_name, String last_name, LocalDate birthday, String username, String password,
			String email, String city, String blood_type, String disease) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.email = email;
		this.city = city;
		this.blood_type = blood_type;
		this.disease = disease;
	}
	
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public LocalDate getBirthday() {
		return birthday;
	}
	
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getBlood_type() {
		return blood_type;
	}
	
	public void setBlood_type(String blood_type) {
		this.blood_type = blood_type;
	}
	
	public String getDisease() {
		return disease;
	}
	
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public String getBlood_centre() {
		return blood_centre;
	}
	
	public void setBlood_centre(String blood_centre) {
		this.blood_centre = blood_centre;
	}
	
	
	
}
