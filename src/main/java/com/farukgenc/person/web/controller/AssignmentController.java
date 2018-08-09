package com.farukgenc.person.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.person.service.AssignmentService;
import com.farukgenc.person.web.resources.AssignmentResource;

@RestController
@RequestMapping("/person/addDepartment")
public class AssignmentController {

	private AssignmentService assignmentService;

	@Autowired
	public AssignmentController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@PostMapping
	public ResponseEntity<AssignmentResource> assignmentDepartment(
			@RequestBody AssignmentResource assignmentResource) {
		return ResponseEntity.ok().body(assignmentService.assignmentDepartment(assignmentResource));
	}

	/*
	 * /person/addDepartment
	 * 
	 * { "personId": 1, "departmentId" 2 }
	 * 
	 * Result;
	 * 
	 * return SuccessAssignmentResource
	 * 
	 * {
	 * 
	 * "personId": "1", "name" : "Faruk", "surname": "Genç", "department": {
	 * "departmentId": 2, "departmentName" : "Arge" } }
	 * 
	 * 
	 */

}
