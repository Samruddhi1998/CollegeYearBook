package com.registration.teacher.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.registration.teacher.model.Teacher;
import com.registration.teacher.service.TeacherService;

//Testing Repository Layer

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void testCreateTeacher() {
		
		Teacher saveInDb = new Teacher(5,"Sanjay","sanjay@gmail.com","Sanjay@123","128,Panaji,Goa","99978948865","Senior.Professor","MSc");
		System.out.println(saveInDb);
		assertThat(saveInDb.getName()).isEqualTo("Sanjay");
	}

	
	@Test
	public void testGetAllTeacherInfo() {
		List<Teacher> teachers = (List<Teacher>) repository.findAll();
		
		teachers.stream().forEach((teacher->
		{
			System.out.println("Teacher Id: "+teacher.getId());
			System.out.println("Teacher Name: "+teacher.getName());
			System.out.println("Teacher Email Id: "+teacher.getEmail());
			System.out.println("Teacher Address: "+teacher.getContact());
			System.out.println("Teacher Designation: "+teacher.getDesignation());
			System.out.println("Teacher Qualification: "+teacher.getQualification());
			System.out.println("***********************************");
		}));
		
		int count=teachers.size();
		System.out.println(count);
		assertThat(teachers).size().isGreaterThan(0);
		assertThat(teachers.size()).isEqualTo(count);
	}
	
	
	@Test
	public void testGetTeacherById() {
		Optional<Teacher> obj=repository.findById(2);
		assertTrue(obj.isPresent());
	}
}
