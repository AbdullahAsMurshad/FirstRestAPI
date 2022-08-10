package com.example.response;

import com.example.entity.Address;
import com.example.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressResponse {

	@JsonIgnore
	private  long id;
	
	@JsonProperty("Street")
	private String street;
	
	@JsonProperty("City")
	private String city;
	
	@JsonProperty("Student")
	private  Student student;
	
	public AddressResponse(Address address) {
		this.street=address.getStreet();
		this.city=address.getCity();
		
		this.student=new Student(address);
	}
}
