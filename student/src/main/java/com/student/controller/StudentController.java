package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student.common.RequestMapper;
import com.student.domain.Student;
import com.student.service.StudentService;
import com.student.service.dto.CreateStudentRequest;
import com.student.service.dto.StudentResponse;
import com.student.service.transformers.StudentTransforer;

@RestController
@RequestMapping(RequestMapper.STUDENT)
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
		Student student = StudentTransforer.createStudentRequestToDomain(createStudentRequest);
		Student createdStudent = studentService.createStudent(student);
		return StudentTransforer.studentDomainToResponse(createdStudent);
	}
	

}
