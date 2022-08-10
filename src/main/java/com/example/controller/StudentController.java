package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.InFirstNameRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@Value("${app.name : Default Rest API name}")
	private String app_name;

	@GetMapping("/getApplicationName")
	// @RequestMapping(value = "/getApplicationName", method= RequestMethod.GET)
	public String getAppName() {
		return app_name;
	}

	@GetMapping("/getAllStudents")
	// @RequestMapping(value = "/getAllStudents", method= RequestMethod.GET)
	public List<StudentResponse> getAllStudents() {

		List<Student> studentList = studentService.getAllStudent();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@PostMapping("create")
	// @RequestMapping(value = "create", method= RequestMethod.POST)
	public StudentResponse create(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		student = studentService.createStudent(student);

		return new StudentResponse(student);
	}

	@PutMapping("update")
	// @RequestMapping(value = "update", method=RequestMethod.PUT)
	public StudentResponse update(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student = new Student(updateStudentRequest);
		student = studentService.updateStudent(student);
		return new StudentResponse(student);
	}

	// this delete api will work like -> apiUrl/delete?id=4(which id needs to be
	// deleted) e.g; http://localhost:8080/api/student/delete?id=11
//	@DeleteMapping("delete")
//	public String delete(@RequestParam("id") long id) {
//		return studentService.deleteStudent(id);
//	}

	// this delete api will work like -> apiUrl/delete/4(which id needs to be
	// deleted) e.g; http://localhost:8080/api/student/delete/10
	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id") long id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getStudentListByFirstName(@PathVariable String firstName) {
		List<Student> studentList = studentService.getStudentListByFirstName(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public List<StudentResponse> findByFirstNameAndLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Student> studentList = studentService.getStudentListByFirstNameAndLastName(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> findByFirstNameOrLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Student> studentList = studentService.getStudentListByFirstNameOrLastName(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	@GetMapping("getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InFirstNameRequest inFirstNameRequest) {
		List<Student> studentList = studentService.getByFirstNameIn(inFirstNameRequest.getFirstNames());

		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	// is tarah ki hit bhejen ge with GET request
	// http://localhost:8080/api/student/getAllUsingPagination?pageNo=2&pageSize=5
	@GetMapping("getAllUsingPagination")
	public List<StudentResponse> getAllUsingPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<Student> studentList = studentService.getAllUsingPagination(pageNo, pageSize);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	@GetMapping("getAllSorted")
	public List<StudentResponse> getAllSorted() {
		List<Student> studentList = studentService.getAllSorted();
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;
	}

	@GetMapping("like/{keyword}")
	public List<StudentResponse> like(@PathVariable String keyword) {
		List<Student> studentList = studentService.findAllLike(keyword);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;
	}

	@GetMapping("startsWith/{keyword}")
	public List<StudentResponse> startsWith(@PathVariable String keyword) {
		List<Student> studentList = studentService.findAllStartsWith(keyword);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;
	}

	@GetMapping("endsWith/{keyword}")
	public List<StudentResponse> endsWith(@PathVariable String keyword) {
		List<Student> studentList = studentService.findAllEndsWith(keyword);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;
	}

	@GetMapping("getAllUsingJPQL/{firstName}/{lastName}")
	public List<StudentResponse> getAllUsingJPQL(@PathVariable String firstName, @PathVariable String lastName) {
		List<Student> studentList = studentService.getAllUsingJPQL(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		return studentResponseList;

	}

	@PutMapping("updateStudentUsingJPQL/{firstName}/{id}")
	public String updateUsingJPQL(@PathVariable String firstName, @PathVariable long id) {
		return studentService.updateStudentUsingJPQL(firstName, id) + " rows updated";
	}

	@DeleteMapping("deleteStudentUsingJPQL/{id}")
	public String deleteUsingJPQL(@PathVariable long id) {
		return studentService.deleteStudentUsingJPQL(id) + " rows deleted";
	}

	/*
	 * from here to downward One to one API will work above one will work only for
	 * student with address_id as null null able is lie rkha takay jo already likha
	 * hua usko na change krna pre
	 * 
	 */

	@PostMapping("createStudentWithAddress")
	public StudentResponse createStudentWithAddress(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		student = studentService.createStudentWithAddress(student);

		return new StudentResponse(student);
	}

	@GetMapping("getStudentUsingCity/{city}")
	public List<StudentResponse> getStudentUsingCity(@PathVariable  String city) {
		
		List<Student> studentList = studentService.getStudentUsingCity(city);
		List<StudentResponse> studentResponseList = new ArrayList<>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;

	}
	
	
	@GetMapping("getString")
	public String getString() {
		return "Hello World. This is  test message.";
	}

}
