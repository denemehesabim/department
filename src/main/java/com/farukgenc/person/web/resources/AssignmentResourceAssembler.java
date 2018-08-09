package com.farukgenc.person.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.farukgenc.person.domain.Person;
import com.farukgenc.person.web.controller.AssignmentController;

public class AssignmentResourceAssembler extends ResourceAssemblerSupport<Person, AssignmentResource>{

	public AssignmentResourceAssembler() {
		super(AssignmentController.class, AssignmentResource.class);
	}

	@Override
	public AssignmentResource toResource(Person person) {
		return null;
	}

	
}
