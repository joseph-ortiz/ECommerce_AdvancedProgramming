package Models;

import java.util.UUID;

public class Address {
	
	public Address(){
		this.id = UUID.randomUUID();
		this.name ="test user";
		this.street = "123 fake street";
		this.apt = "suite b";
		this.city = "atlanta";
		this.state = "GA";
		this.country = "USA";
		this.zipCode = 30097;
		
	}
	
	public UUID id;
	public String name;
	public String street;
	public String apt;
	public String city;
	public String state;
	public String country;
	public int zipCode;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isValid() {
		Boolean isValid = true;
		if(this.name.isEmpty()) isValid = false;
		if(this.street.isEmpty()) isValid = false;
		if(this.city.isEmpty()) isValid = false;
		if(this.zipCode == 0) isValid = false;
		if(this.country.isEmpty()) isValid = false;
		
		//System.out.println("Validated address, returned: " + isValid);
		return isValid;
	}
	
	
}
