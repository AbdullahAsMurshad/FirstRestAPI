package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.commonUtils.Utils;
import com.example.entity.Address;
import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student) {
		student = studentRepository.save(student);
		return student;
	}
	
	public Student updateStudent(Student student) {
		
		if(! Utils.isNullOrEmpty(student.getFirstName()) ) {
			student = studentRepository.save(student);
		}

		return student;
	}
	
	public String deleteStudent(long id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "student has been deleted.";
		}
		return "No Such Student Exist.";
	}
	
	public List<Student> getStudentListByFirstName(String firstName){
		return studentRepository.findByFirstName(firstName);
	}
	
	public List<Student> getStudentListByFirstNameAndLastName(String firstName, String lastName){
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Student> getStudentListByFirstNameOrLastName(String firstName, String lastName){
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameIn(List<String> firstNames){
		return studentRepository.findByFirstNameIn(firstNames);
	}
	
	//batching wala kaam hai 
	public List<Student> getAllUsingPagination(int pageNo, int pageSize){
		Pageable pageable= PageRequest.of(pageNo -1 ,pageSize);
		return studentRepository.findAll(pageable).getContent();
	}
	
	//Sort.Direction will decide the direction either asceding or desending
	public List<Student> getAllSorted(){
		Sort sort = Sort.by(Sort.Direction.ASC,"firstName");
		return studentRepository.findAll(sort);
	}
	
	public List<Student> findAllLike(String keyword){
		return studentRepository.findByFirstNameContains(keyword);
	}
	
	public List<Student> findAllStartsWith(String keyword){
		return studentRepository.findByFirstNameStartsWith(keyword);
	}
	
	public List<Student> findAllEndsWith(String keyword){
		return studentRepository.findByFirstNameEndsWith(keyword);
	}
	
	public List<Student> getAllUsingJPQL(String firstName, String lastName){
		return studentRepository.getAllUsingJPQL(firstName,lastName);
	}
	
	public int updateStudentUsingJPQL(String firstName,long id) {
		return studentRepository.updateStudentFirstNameUsingJPQL(firstName, id);
	}
	
	public int deleteStudentUsingJPQL(long id) {
		return studentRepository.deleteStudentUsingJPQL( id);
	}
	
	public Student createStudentWithAddress(Student student) {
		
		Address address=new Address(student.getAddress().getStreet(), 
				student.getAddress().getCity());
		
		address= addressRepository.save(address);
		
		student.setAddress(address);

		student= studentRepository.save(student);
		
		
		return student;
	}
	
	public List<Student> getStudentUsingCity(String city){
		return studentRepository.findByAddressCity(city);
	}

}