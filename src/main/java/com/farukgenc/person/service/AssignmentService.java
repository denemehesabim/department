package com.farukgenc.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.domain.Person;
import com.farukgenc.person.repository.DepartmentRepository;
import com.farukgenc.person.repository.PersonRepository;
import com.farukgenc.person.web.resources.AssignmentResource;

@Service
public class AssignmentService {

	private PersonRepository personRepository;
	private DepartmentRepository departmentRepository;
	
	
	@Autowired
	public AssignmentService(PersonRepository personRepository,DepartmentRepository departmentRepository) {
		this.personRepository = personRepository;
		this.departmentRepository = departmentRepository;
	}

	public AssignmentResource assignmentDepartment(AssignmentResource assignmentResource) {
		List<Person> person = personRepository.findByIdIn(assignmentResource.getPersonId());
		Optional<Department> department = departmentRepository.findById(assignmentResource.getDepartmentId());
		
		departmentRepository.save(department.get());
		return assignmentResource;
	}
	
	
	
}
