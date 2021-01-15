package com.registration.teacher.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.registration.teacher.model.Teacher;
import com.registration.teacher.repository.TeacherRepository;
import com.registration.teacher.service.TeacherService;
import com.registration.teacher.service.TeacherServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/registration")
public class TeacherController {

	@Autowired
	private TeacherServiceImpl service;
	
	
	@GetMapping(value = "/teacher")
	public List<Teacher> findAll() {
		
		return service.getAllTeacherInfo();
	}

	
	@PostMapping("/teacher")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createTeacher(@Valid @RequestBody Teacher newteacher) {
		Teacher teacher=service.createTeacher(newteacher);
		int id=teacher.getId();
		return new ResponseEntity<String>("Teacher with ID:"+id+" is Created Successfully",HttpStatus.OK);
	}

	
	@GetMapping(value = "/teacher/{id}")
	public Teacher getTeacherById(@PathVariable int id) {
		
		return service.findById(id);
	}
	
	@PutMapping(value= "/teacher/{id}")
	public Teacher updateTeacher(@RequestBody Teacher newTeacher,@PathVariable int id) {
		return service.updateTeacherById(id);
	}
	
	
	@DeleteMapping(value="/teacher/{id}")
	public void deleteTeacher(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
