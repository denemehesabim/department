package com.farukgenc.person.web.resources;

import org.springframework.hateoas.ResourceSupport;

public class DepartmentResource extends ResourceSupport {

	private Long departmentId;

	private String departmentName;

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
