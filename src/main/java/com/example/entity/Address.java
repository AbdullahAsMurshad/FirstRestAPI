package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Address")
public class Address {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private long id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	/*
	 * iska matlab ye hai k jab  ham log address ka record fetch kren ge tb ye hamain us address se associated student bhi return kr de ga
	 * 
	 */
	@OneToOne(mappedBy = "address")
	@JsonIgnore
	private Student student;
//	
	public Address(long id,String street,String city) {
		setId(id);
		setCity(city);
		setStreet(street);
	}
	public Address(String street,String city) {
		
		setCity(city);
		setStreet(street);
	}
	
	public Address (Student student) {
		this.street=student.getAddress().getStreet();
		this.city=student.getAddress().getCity();
	}
	
}
