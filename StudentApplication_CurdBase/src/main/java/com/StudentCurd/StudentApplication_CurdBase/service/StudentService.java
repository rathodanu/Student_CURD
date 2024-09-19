package com.StudentCurd.StudentApplication_CurdBase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.StudentCurd.StudentApplication_CurdBase.entity.Student;
import com.StudentCurd.StudentApplication_CurdBase.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	public void addStudent(Student ss) {
		repo.save(ss);	
		
	}

	public Student updateStudent(Student ss, long id) {
	 Student student = repo.findById(id).get();
	 student.setName(ss.getName());
	 student.setFee(ss.getFee());
	 student.setCourse(ss.getCourse());
	 student.setMob(ss.getMob());
	 repo.save(student);
	 return student;
		
	}

	public List<Student> studentList() {
		List<Student> allList = repo.findAll();
		return allList;
		
	}

	public Student getStudent(long id) {
		   Student student = repo.findById(id).get();
		return student;
		
		
	}

	public void deleteStudent(long id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
		
	}

	public List<Student> pagination(int pageNum, int pageSize) {
		Page<Student> pageStudent = repo.findAll(PageRequest.of(pageNum, pageSize));
		return pageStudent.getContent();
		
	}

	public List<Student> sortByName(String name) {
		
		List<Student> all = repo.findAll(Sort.by(Sort.Direction.DESC,name));
		return all;
		
	}

	public List<Student> findByNameAndByCourse(String name, String course) {
		List<Student> byNameAndByCourse = repo.findByNameIgnoreCaseAndCourseIgnoreCase(name, course);
		return byNameAndByCourse;
		
	}

	public List<Student> findByFee(int fee1, int fee2) {
		List<Student> byFeeBetween = repo.findByFeeBetween(fee1, fee2);
		return byFeeBetween;
	
		
	}

	public List<Student> paginationAndSorting(int pageNum, int pageSize, String name) {
		Page<Student> all = repo.findAll(PageRequest.of(pageNum, pageSize).withSort(Sort.Direction.DESC,name));
		List<Student> content = all.getContent(); 
		return content;
		
	}

	
	


}
