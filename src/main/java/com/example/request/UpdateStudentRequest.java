package com.example.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
public class UpdateStudentRequest {

	@JsonProperty("Id")
	@NotNull(message = "Id is required to update student record")
	private Long id;
	
	@JsonProperty("First_Name")
	private String firstName;

	@JsonProperty("Last_Name")
	private String lName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("street")
	private String street;
	
	
}