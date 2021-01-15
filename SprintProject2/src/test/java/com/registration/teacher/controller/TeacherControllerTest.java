package com.registration.teacher.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.registration.teacher.model.Teacher;
import com.registration.teacher.service.TeacherServiceImpl;

//Testing Controller Layer


@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerTest {

	    @Autowired
		private MockMvc mockMvc;

	    @MockBean
	    private TeacherServiceImpl service;
	    
	    @Test
	    public void testGetAllTeacherInfo() throws Exception{
	    	Teacher t1=new Teacher(1,"Vijay","vijay@gmail.com","Vijay@123","45,Balaji Nagar,Nagpur","7897894886","Professor","Phd");
	    	Teacher t2=new Teacher(2,"Ajay","ajay@gmail.com","Ajay#123","145,Durga Nagar,Nagpur","9897894886","Professor","MSc");
	    	
	    	List<Teacher> teacherList=Arrays.asList(t1,t2);
	    	when(service.getAllTeacherInfo()).thenReturn(teacherList);
	    	 
	    	String URI="/registration/teacher";
	    	RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON); 
	    	
			MvcResult result=mockMvc.perform(requestBuilder).andReturn();
	    	
			String expectedJson=this.mapToJson(teacherList);
			String outputInJson=result.getResponse().getContentAsString();
			
			assertThat(outputInJson).isEqualTo(expectedJson);
	    	
	    }
	    
	 
		@Test
	    public void testGetTeacherById() throws Exception {

			Teacher t1=new Teacher(1,"Vijay","vijay@gmail.com","Vijay@123","45,Balaji Nagar,Nagpur","7897894886","Professor","Phd");
			Mockito.when(service.getTeacherById(Mockito.anyInt())).thenReturn(t1);
			String URI="/registration/teacher/1";
			
			RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON); 
			MvcResult result=mockMvc.perform(requestBuilder).andReturn();
			String expectedJson=this.mapToJson(t1);
			String outputInJson=result.getResponse().getContentAsString();
			
	    }
	   
		
		@Test
		public void testSaveTeacher() throws Exception{
			
			String URI="/registration/createTeacher";
			Teacher t1=new Teacher(1,"Vijay","vijay@gmail.com","Vijay@123","45,Balaji Nagar,Nagpur","7897894886","Professor","Phd");
			String inputInJson=this.mapToJson(t1);
			Mockito.when(service.save(Mockito.any(Teacher.class))).thenReturn(t1);
			RequestBuilder requestBuilder=MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
					.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
			MvcResult result=mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response=result.getResponse();
			
			String outputInJson=response.getContentAsString();
			
		}
		
		private String mapToJson(Object object) throws JsonProcessingException {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(object);
		}


}
