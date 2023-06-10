package com.example.hibernate;

import com.example.hibernate.entity.Passport;
import com.example.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootHibernateApplication implements CommandLineRunner {

    @Autowired
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //When Student is the owning side of relationship
        Student student = entityManager.find(Student.class, 1L);
        log.info("Student -> {}", student);
        log.info("Get Passport from Student -> {}", student.getPassport());

        //when passport is the owning side of the relationship
        Passport passport = entityManager.find(Passport.class, 1L);
        log.info("Passport -> {}", passport);
        log.info("Get Student from Passport  -> {}", passport.getStudent());
    }

}
