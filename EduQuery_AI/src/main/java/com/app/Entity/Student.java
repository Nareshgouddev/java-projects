package com.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Student {
	@Id
	private Integer roll_Id;
	private String name;
	private String course;
	private Double cgpa;
	private Double calculateGpa;
	
	Student(){
		
	}
	public Student(Integer roll_Id, String name, String course, Double cgpa, Double calculateGpa) {
		this.roll_Id = roll_Id;
		this.name = name;
		this.course = course;
		this.cgpa = cgpa;
		this.calculateGpa = calculateGpa;
	}

	public Integer getRoll_Id() {
		return roll_Id;
	}

	public void setRoll_Id(Integer roll_Id) {
		this.roll_Id = roll_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public Double getCalculateGpa() {
		return calculateGpa;
	}
	public void setCalculateGpa(Double calculateGpa) {
		this.calculateGpa = calculateGpa;
	}
	public String toString() {
		return "Student [roll_Id=" + roll_Id + ", name=" + name + ", course=" + course + ", cgpa=" + cgpa
				+ ", calculateGpa=" + calculateGpa + "]";
	}	
}
