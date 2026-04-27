package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.Entity.Student;

import jakarta.transaction.Transactional;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{
	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.name = :newName WHERE s.roll_Id = :id")
	int updateStudent(Integer id, String newName);
	
	
}
