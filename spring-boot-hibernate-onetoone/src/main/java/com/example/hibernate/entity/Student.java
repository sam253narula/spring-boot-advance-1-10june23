package com.example.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

//	@OneToOne
//	private Passport passport;

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    protected Student() {
    }

    public Student(String name) {
        this.name = name;
    }

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
//	}

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }


}