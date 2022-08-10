package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.request.CreateStudentRequest;
import com.example.request.UpdateStudentRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter	
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private  String lastName;
	
	@Column(name = "email")
	private String email;
	
	/*
	 * fetch type is required when we need to use Lazy loading
	 * lazy loading is when we want to fire query when we call getter method it will not automatically fire select query without calling getter method
	 * if we don't call getter methods select queries will not be fired
	 * the extra fired queries are when we fetch rows using joins it will also fetch rows for the foriegn key wala table
	 * in this case student ka data chiye but wo Address k objects bhi lata ja rha hai aur wo bhi one by one query kr k which is wrong what if we don't want address objects
	 */
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
	@JsonIgnore
	private Address address;
	
	
	//if we want to define some members those do not exist in model class's table mark it transient so when JPA will 
	//return the result of your query it will ignore transient members as it could not map these members to table's column so they
	//will be ignored automatically.
	
	@Transient
	private String fullName;

	public Student(CreateStudentRequest createStudentRequest) {
		this.firstName=createStudentRequest.getFName();
		this.lastName=createStudentRequest.getLName();
		this.email=createStudentRequest.getEmail();
		
		this.fullName=this.firstName+" "+this.lastName;
		
		this.address=new Address(createStudentRequest.getStreet(),createStudentRequest.getCity());
	}
	
	public Student(UpdateStudentRequest updateStudentRequest) {
		
		this.id=updateStudentRequest.getId();
		this.firstName=updateStudentRequest.getFirstName();
		this.lastName=updateStudentRequest.getLName();
		this.email=updateStudentRequest.getEmail();
		
		this.fullName=this.firstName+" "+this.lastName;
		
		this.address.setCity(updateStudentRequest.getCity());
		this.address.setStreet(updateStudentRequest.getStreet());
	}
	
	
	public Student(Address address) {
		this.firstName=address.getStudent().getFirstName();
		this.lastName=address.getStudent().getLastName();
		this.email=address.getStudent().getEmail();
		
		this.fullName=this.firstName+" "+this.lastName;
		
	}
}
