package com.farukgenc.person.web.resources;

import org.springframework.hateoas.ResourceSupport;

import com.farukgenc.person.domain.Department;

public class SuccessAssignmentResource extends ResourceSupport {

	private Long personId;

	private String name;

	private String surname;

	private Department department;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
