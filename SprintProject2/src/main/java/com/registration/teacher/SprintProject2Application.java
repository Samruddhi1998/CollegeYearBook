package com.registration.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.registration.teacher.model.Teacher;
import com.registration.teacher.repository.TeacherRepository;


@SpringBootApplication
public class SprintProject2Application implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(SprintProject2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
