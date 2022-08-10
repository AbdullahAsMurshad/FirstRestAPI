package com.example.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

	
	@JsonProperty("First_Name")
	@NotBlank(message = "First Name is mandatory")
	private String fName;
	
	@JsonProperty("Last_Name")
	private String lName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("street")
	private String street;
	
	@JsonProperty("city")
	private String city;
	
}
