package com.example.hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

//    	@ManyToMany
//    	@JoinTable(name = "COURSE_ENROLLED_BY_STUDENTS", joinColumns = @JoinColumn(name ="COURSE_ID"),
//	inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

//	@Override
//	public String toString() {
//		return String.format("Course[%s]", name);
//	}
}