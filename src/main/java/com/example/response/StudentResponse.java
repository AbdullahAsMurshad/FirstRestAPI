package com.example.response;

import com.example.entity.Address;
import com.example.entity.Student;
import com.fasterxml.jackson.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

/*
@Setter
@Getter
@ToString
@EqualsAndHashCode
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	
	//@JsonProperty("ID")
	@JsonIgnore
	private Long id;
	
	@JsonProperty("First_Name")
	private String fName;
	
	@JsonProperty("Last_Name")
	private String lName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("Address")
	private Address address;
	
	public StudentResponse(Student student) {
		this.id=student.getId();
		this.fName=student.getFirstName();
		this.lName=student.getLastName();
		this.email=student.getEmail();
		
		this.address=new Address(student);
		
	}

}
