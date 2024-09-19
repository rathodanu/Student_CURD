package com.StudentCurd.StudentApplication_CurdBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentCurd.StudentApplication_CurdBase.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long>{
	
	public List<Student> findByNameIgnoreCaseAndCourseIgnoreCase(String name , String course);
	public List<Student> findByFeeBetween(int fee1, int fee2);
	
	
	

}
