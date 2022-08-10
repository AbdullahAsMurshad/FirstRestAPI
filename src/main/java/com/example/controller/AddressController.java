package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.response.AddressResponse;
import com.example.response.StudentResponse;
import com.example.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired 
	AddressService addressService;
	
	@GetMapping("getAllAddresses")
	public List<AddressResponse> getAllAddresses(){
		
		List<Address> addressList = addressService.getAllAddresses();
		List<AddressResponse> addressResponseList = new ArrayList<AddressResponse>();

		addressList.stream().forEach(address -> {
			addressResponseList.add(new AddressResponse(address));
		});

		return addressResponseList;
		
		
	}
	

}
