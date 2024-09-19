package com.StudentCurd.StudentApplication_CurdBase.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCurd.StudentApplication_CurdBase.entity.Student;
import com.StudentCurd.StudentApplication_CurdBase.responseDTO.ResponseDTO;
import com.StudentCurd.StudentApplication_CurdBase.service.StudentService;


@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping(path="/create")
	public ResponseEntity<Student> addStudent(@RequestBody Student ss)
	{
		service.addStudent(ss);
		return ResponseEntity.ok(ss);
		
	}
	
	@RequestMapping(path="/update/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student ss , @PathVariable long id)
	{
	
		Student updateStudent = service.updateStudent(ss, id);
		return ResponseEntity.ok(updateStudent);
		
	}
	
	@GetMapping(path="list")
	public ResponseEntity<List<Student>> studentList()
	{
		List<Student> studentList = service.studentList();
		return ResponseEntity.ok(studentList);
	}
	
	@GetMapping(path="get/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id)
	{
		Student student = service.getStudent(id);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id)
	{
		service.deleteStudent(id);
		return ResponseEntity.ok("Data Deleted Successfully!!!!!!");
	}
	
	@GetMapping(path="/findAll")
	public List<Student> pagination(
			@RequestParam (value="pagenum" , defaultValue = "0" , required = false ) int pageNum,
			@RequestParam (value ="pagesize" , defaultValue = "5" , required = false) int pageSize
			)
	{
		List<Student> allStudent = service.pagination(pageNum , pageSize);
		return allStudent;
		
	}
	
	@GetMapping(path="sort/{name}")
	public ResponseEntity<List<Student>> sortByName( @PathVariable ("name") String name)
	{
		List<Student> sort = service.sortByName(name);
		return ResponseEntity.ok(sort);
		
	}
	
	@GetMapping(path="FindByNameAndCourse/{name}/{course}")
	public ResponseEntity<List<Student>> findByNameAndByCourse(@PathVariable ("name") String name , @PathVariable ("course") String course)
	{
		List<Student> byNameAndByCourse = service.findByNameAndByCourse(name,course);
		return ResponseEntity.ok(byNameAndByCourse);
	}
	
	@GetMapping(path ="byfee/{fee1}/{fee2}")
	public ResponseDTO findByFee(@PathVariable("fee1") int fee1 , @PathVariable("fee2") int fee2)
	{
		List<Student> byFee = service.findByFee(fee1, fee2);
		if(byFee != null)
		{
		return new ResponseDTO(true, byFee, "Success");
		}
		else
		{
			return new ResponseDTO(false, null, "Failed");
		}
	}
	
	//pagination and sorting
	
	@GetMapping(path = "PagineAndSort/{field}")
	public List<Student> paginationAndSorting(@RequestParam (value= "pageNum" , defaultValue = "0" , required = false )  int pageNum , 
			@RequestParam (value= "pageSize", defaultValue = "3" , required = false ) int pageSize ,
			@PathVariable ("field") String name)
	{
		List<Student> paginationAndSorting = service.paginationAndSorting(pageNum,pageSize, name);
		return paginationAndSorting;
		
	}

	

	
	
	
}
