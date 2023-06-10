package com.example.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private int rating;

	private String description;
	
	@ManyToOne
	private Course course;
	
}