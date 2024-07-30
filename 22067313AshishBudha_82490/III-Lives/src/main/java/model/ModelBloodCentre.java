package model;

import java.time.LocalDate;

public class ModelBloodCentre {
	private String centreName;
	private String city;
	private LocalDate startDate;
	private LocalDate endDate;
	private String location;
	
	public ModelBloodCentre() 
	{
	}
	
	public ModelBloodCentre(String centreName, String city, LocalDate startDate, LocalDate endDate, String location) {
		super();
		this.centreName = centreName;
		this.city = city;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}


	public String getCentreName() {
		return centreName;
	}


	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
