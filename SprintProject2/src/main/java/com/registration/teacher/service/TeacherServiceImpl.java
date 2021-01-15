package com.registration.teacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.registration.teacher.exception.InputException;
import com.registration.teacher.model.Teacher;
import com.registration.teacher.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	@Override
	public List<Teacher> getAllTeacherInfo() {
		// TODO Auto-generated method stub
		return (List<Teacher>)repository.findAll();
	}

	@Override
	public Teacher createTeacher(Teacher teacher) {
		return repository.save(teacher);
	}
	
	@Override
	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	

	public Teacher save(Teacher teacher) {
		// TODO Auto-generated method stub
		if(teacher.getName()==null) {
			throw new InputException("Please enter Teacher name");
		}
		else if(teacher.getEmail()==null) {
			throw new InputException("Please Enter email Id");
		}
		else if(teacher.getAddress()==null) {
			throw new InputException("Please Enter Address");
		}
		else if(teacher.getContact()==null) {
			throw new InputException("Please enter contact number");
		}
		else if(teacher.getDesignation()==null) {
			throw new InputException("Please enter designation");
		}
		else if(teacher.getQualification()==null) {
			throw new InputException("Please enter Qualification");
		}
		
		try {
			return repository.save(teacher);
		}
		catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new InputException("This UserId is already registered....Please Login....");
		}
		
		
	}

	public Teacher findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteTeacher(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
		
	}

	@Override
	public Teacher updateTeacherById(int id) {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher)repository.findById(id).get();
		return repository.save(teacher);
		
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

	
}

	

