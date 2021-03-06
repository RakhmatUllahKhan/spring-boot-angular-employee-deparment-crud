package com.myProject.myProject.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.myProject.model.Employee;
import com.myProject.myProject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee save(Employee employee) {
		if (employee.getId() != null && employeeRepository.existsById(employee.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return employeeRepository.save(employee);
	}

	public Employee update(Employee employee) {
		if (employee.getId() != null && !employeeRepository.existsById(employee.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return employeeRepository.save(employee);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findOne(Integer id) {
		return employeeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

	
}
