package com.farukgenc.person.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.exception.DepartmentNotFoundException;
import com.farukgenc.person.repository.DepartmentRepository;
import com.farukgenc.person.web.resources.DepartmentResource;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public Department addDepartment(DepartmentResource departmentResource) {
		Department department = new Department();
		department.setId(departmentResource.getDepartmentId());
		department.setName(departmentResource.getDepartmentName());
		return departmentRepository.save(department);
	}

	public Department updateDepartment(DepartmentResource departmentResource) throws DepartmentNotFoundException {
		Optional<Department> tempDepartment = departmentRepository.findById(departmentResource.getDepartmentId());
		if (tempDepartment.isPresent()) {
			Department department = new Department();
			department.setId(departmentResource.getDepartmentId());
			department.setName(departmentResource.getDepartmentName());
			return departmentRepository.save(department);
		}
		throw new DepartmentNotFoundException("404", "Department Not Found Brooo!");
	}

	public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> tempDepartment = departmentRepository.findById(departmentId);
		if(tempDepartment.isPresent()) {
			return tempDepartment.get();
		}
		else {
			throw new DepartmentNotFoundException("404", "Department Not Found Brooo!");
		}
	}


}
