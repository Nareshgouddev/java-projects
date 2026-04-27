package com.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Student;
import com.app.Repository.StudentRepo;

@Service
public class StudentService {
	 @Autowired
	 private StudentRepo studentrepo;
	 
	 public Student save(Student s) {
		return studentrepo.save(s);
	 }
	 
	 public List<Student> saveall(List<Student> s) {
		 return studentrepo.saveAll(s);
	 } 
	 
	 public void delete(Integer id) {
		 studentrepo.deleteById(id);
	 }
	 
	 public Student updateStudent(Integer id, String newName) {
		    studentrepo.updateStudent(id, newName);  
		    return studentrepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	 }
	 public Optional<Student> findByid(Integer id) {
		 return studentrepo.findById(id);
	 }
	 public List<Student> findAll() {
		    return studentrepo.findAll();
		}
	 
}
