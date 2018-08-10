package com.farukgenc.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.domain.Person;
import com.farukgenc.person.repository.DepartmentRepository;
import com.farukgenc.person.repository.PersonRepository;
import com.farukgenc.person.web.resources.AssignmentResource;
import com.farukgenc.person.web.resources.PersonResource;
import com.farukgenc.person.web.resources.SuccessAssignmentResource;

@Service
public class AssignmentService {

	private PersonRepository personRepository;
	private DepartmentRepository departmentRepository;

	@Autowired
	public AssignmentService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
		this.personRepository = personRepository;
		this.departmentRepository = departmentRepository;
	}

	@Transactional
	public AssignmentResource assignmentDepartment(AssignmentResource assignmentResource) {
		List<Person> person = personRepository.findByIdIn(assignmentResource.getPersonIdList());
		Optional<Department> department = departmentRepository.findById(assignmentResource.getDepartmentId());
		department.get().setPerson(person);
		person.forEach(p -> {
			p.setDepartment(department.get());
			personRepository.save(p);
		});
		departmentRepository.save(department.get());
		return assignmentResource;
	}

	public SuccessAssignmentResource assignDepartmentSuccess(AssignmentResource assignmentResource) {
		List<Person> person = personRepository.findByIdIn(assignmentResource.getPersonIdList());
		Optional<Department> department = departmentRepository.findById(assignmentResource.getDepartmentId());
		department.get().setPerson(person);
		PersonResource personResource = new PersonResource();
		List<PersonResource> personList = new ArrayList<>();
		person.forEach(p -> {
			p.setDepartment(department.get());
			personRepository.save(p);
			personResource.setName(p.getName());
			personResource.setPersonId(p.getId());
			personResource.setSurname(p.getSurname());
			personList.add(personResource);
		});
		departmentRepository.save(department.get());

		SuccessAssignmentResource successAssignmentResource = new SuccessAssignmentResource();
		successAssignmentResource.setPersonList(personList);
		return successAssignmentResource;
	}

}
