package com.myProject.myProject.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.myProject.myProject.model.Employee;
import com.myProject.myProject.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
@RestController
@RequestMapping("/api")
public class EmployeeController {	

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	
	@RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Integer id) throws URISyntaxException {
		        	Optional<Employee> employee = employeeService.findOne(id);
		        return ResponseEntity.ok().body(employee);
	}

	@RequestMapping(value = "employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws URISyntaxException {
		try {
			Employee result = employeeService.save(employee);
			return ResponseEntity.created(new URI("/api/employee/" + result.getId())).body(result);
		} catch (EntityExistsException e) {			
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		
	}
	}

	
	@RequestMapping(value = "employee", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws URISyntaxException {
		if (employee.getId() == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		try {
			Employee result = employeeService.update(employee);

			return ResponseEntity.created(new URI("/api/employee/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
		employeeService.delete(id);

		return ResponseEntity.ok().build();
	}
}
  
