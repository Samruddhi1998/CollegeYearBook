package com.registration.teacher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registration.teacher.model.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

	public Teacher findByName(String name);

}
