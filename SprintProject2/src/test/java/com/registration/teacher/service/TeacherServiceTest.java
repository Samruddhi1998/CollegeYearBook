package com.registration.teacher.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Equals;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.registration.teacher.model.Teacher;
import com.registration.teacher.repository.TeacherRepository;
import com.registration.teacher.service.TeacherServiceImpl;

//Testing Service Layer

class TeacherServiceTest {
	
	@Autowired
	private TeacherServiceImpl service;

	@MockBean
	private TeacherRepository repository;
	
	//Testing Service Layer
	
	@Test
	public void getAllTeacherInfoTest() {
		
		List<Teacher> list=new ArrayList<Teacher>();
		Teacher t1=new Teacher(1,"Vijay","vijay@gmail.com","Vijay@123","45,Balaji Nagar,Nagpur","78978948865","Professor","Phd");
		Teacher t2=new Teacher(2,"Jay","jay@gmail.com","Jay@123","234,Manewada Road,Pune","98978948865","Ass.Professor","MTech");
		
		list.add(t1);
		list.add(t2);
		
		List<Teacher> teacherList=Arrays.asList(t1,t2);
		assertEquals(2,teacherList.size());	
	}
	

}
