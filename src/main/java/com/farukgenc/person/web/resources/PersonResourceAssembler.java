package com.farukgenc.person.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.person.domain.Person;
import com.farukgenc.person.web.controller.PersonController;
@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {

	public PersonResourceAssembler() {
		super(PersonController.class, PersonResource.class);
	}

	@Override
	public PersonResource toResource(Person person) {
		PersonResource personResource = new PersonResource();
		personResource.setPersonId(person.getId());
		personResource.setName(person.getName());
		personResource.setSurname(person.getSurname());
		return personResource;
	}

}
