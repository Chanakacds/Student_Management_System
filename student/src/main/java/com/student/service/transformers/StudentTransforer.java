package com.student.service.transformers;

import org.springframework.beans.BeanUtils;

import com.student.domain.Student;
import com.student.service.dto.CreateStudentRequest;
import com.student.service.dto.StudentResponse;

public final class StudentTransforer {
	
	private StudentTransforer(){
		
	}
	
	public static Student createStudentRequestToDomain(CreateStudentRequest createRequest) {
		Student target= new Student();
		BeanUtils.copyProperties(createRequest, target);
		return target;
	}
	
	public static StudentResponse studentDomainToResponse(Student student) {
		StudentResponse target = new StudentResponse();
		BeanUtils.copyProperties(student, target);
		return target;
		
	}

}
