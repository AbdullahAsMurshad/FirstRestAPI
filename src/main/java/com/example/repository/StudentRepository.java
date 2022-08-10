package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
		
	//these all are based on firstt name however other could also be written the same way as for first name with no differene
	//only the setter/getter will be used of respective member
	//we can any column name as per our requirement to fetch rows
	List<Student> findByFirstName(String firstName);
		
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Student> findByFirstNameIn(List<String> firstNames);

	List<Student> findByFirstNameContains(String keyword);
	
	List<Student> findByFirstNameStartsWith(String keyword);

	List<Student> findByFirstNameEndsWith(String keyword);
	
	
	/*is ko 2 tarekay se likh skte hain  ---  ye JPQL hai jab ham har query ko JPA k
	method facing technique se na likh skte hon to phr aise JPQL bhi use kr skte hain
	jab method me parameters ka name aur jpql query me parameter name same na hon to @Param notation use krte hain 
	*/

	@Query("from Student where first_name = :firstName and last_name = :lastName")
	//@Query("from Student where first_name = ?1 and last_name = ?2")
	List<Student> getAllUsingJPQL(@Param("firstName") String firstName, @Param("lastName") String lastName);


	@Modifying
	@Transactional
	@Query("Update Student set first_name = ?1 where id = ?2")
	Integer updateStudentFirstNameUsingJPQL(String firstName, long id);
	
	
	@Modifying
	@Transactional
	@Query("Delete from Student  where id = ?1")
	Integer deleteStudentUsingJPQL(long id);
	
	/*
	 * The same way we can write quries using joins as well either using JPQL or JPA
	 * 	//

	 * */
	
	//this method will return rows after fetching based on city. it will use join automatically
	List<Student> findByAddressCity(String city);
	
}
