package com.sat_results.Models;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "SAT_RESULTS")
public class satResults {
	@Id
	@Column(name = "Name")
	private String name = "Default Name";
	@Column(name = "Address")
	private String address;
	@Column(name = "City")
	private String city;
	@Column(name = "Country")
	private String country;
	@Column(name = "Pincode")
	private int pincode;
	@Column(name = "Score")
	private int satscore;
	@Column(name = "Result")
	private String result;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!= null)
		this.name = name;
		else
			this.name = "Enter your name";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getSat_score() {
		return satscore;
	}
	public void setSat_score(int sat_score) {
		this.satscore = sat_score;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public satResults() {
		
	}
	public satResults(String name, String address, String city, String country, int pincode, int sat_score) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.pincode = pincode;
		this.satscore = sat_score;
	}
	
//	  @PrePersist
//	    public void prePersist() {
//	        if (this.name == null) {
//	            // Set the default value for the ID field
//	            this.name = "Default Name"; // Replace with your desired default value
//	        }
//	    }
	
	
	@Override
	public String toString() {
		return "satResults [name=" + name + ", address=" + address + ", city=" + city + ", country=" + country
				+ ", pincode=" + pincode + ", sat_score=" + satscore + ", result=" + result + "]";
	}
	
	
	
	
	

	
	
	
	
}
