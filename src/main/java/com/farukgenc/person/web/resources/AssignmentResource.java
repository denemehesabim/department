package com.farukgenc.person.web.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.farukgenc.person.domain.Person;

public class AssignmentResource extends ResourceSupport {

	private List<Person> personId;

	private Long departmentId;

	public List<Person> getPersonId() {
		return personId;
	}

	public void setPersonId(List<Person> personId) {
		this.personId = personId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
