package com.farukgenc.person.web.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class SuccessAssignmentResource extends ResourceSupport {

	private List<PersonResource> personList;

	public List<PersonResource> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonResource> personList) {
		this.personList = personList;
	}

}
