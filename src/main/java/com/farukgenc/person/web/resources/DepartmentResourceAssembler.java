package com.farukgenc.person.web.resources;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.web.controller.PersonController;
@Component
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource>{

	public DepartmentResourceAssembler() {
		super(PersonController.class, DepartmentResource.class);
	}

	@Override
	public DepartmentResource toResource(Department department) {
		DepartmentResource departmentResource = new DepartmentResource();
		departmentResource.setDepartmentId(department.getId());
		departmentResource.setDepartmentName(department.getName());
		return departmentResource;
	}

}
