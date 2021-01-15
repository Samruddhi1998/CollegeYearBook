package com.registration.teacher.service;

import java.util.List;

import com.registration.teacher.model.Teacher;

public interface TeacherService {

	public List<Teacher> getAllTeacherInfo();

	public Teacher createTeacher(Teacher teacher);

	public Teacher save(Teacher teacher);

	public Teacher getTeacherById(int id);
	
	public void deleteTeacher(int id);
	
	public Teacher updateTeacherById(int id);
}
