package org.techhub.SpringMobileApplicationMvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.SpringMobileApplicationMvc.model.Student;
import org.techhub.SpringMobileApplicationMvc.repositroy.StudentRepo;

//@Service("studentService")
public class StudentService {

	
	StudentRepo studentRepo=new StudentRepo();

	// insert into student values
	public boolean isaddStudent(Student s) {

		return studentRepo.AddStudent(s);
	}

	// data fetch method
	public List<Student> viewStudent() {

		return studentRepo.viewStudent();
	}

	// delete record

	public boolean delRecord(int id) {
		return studentRepo.delRecord(id);
	}

	// Update record
	public boolean update(Student s) {

		return studentRepo.update(s);
	}
	// search record

	public List<Student> search(String name) {

		return studentRepo.searchStudent(name);
	}

	public boolean validateEmail(Student students) {
		return new StudentRepo().validateEmail(students);
	}

}
