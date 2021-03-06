package com.myProject.myProject.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.myProject.model.Department;
import com.myProject.myProject.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/api")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping(value = "department", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getAllDepartments() {
		return departmentService.findAll();
	}

	@RequestMapping(value = "department", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) throws URISyntaxException {
		Department result = departmentService.save(department);

		return ResponseEntity.created(new URI("/api/department/" + result.getId())).body(result);
	}

	@RequestMapping(value = "department", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) throws URISyntaxException {
		if (department.getId() == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}

		try {
			Department result = departmentService.update(department);

			return ResponseEntity.created(new URI("/api/department/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
		departmentService.delete(id);

		return ResponseEntity.ok().build();
	}

}
