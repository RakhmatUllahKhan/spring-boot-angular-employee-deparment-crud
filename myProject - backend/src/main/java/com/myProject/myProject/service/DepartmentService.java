package com.myProject.myProject.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.myProject.model.Department;
import com.myProject.myProject.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
//	public DepartmentService(DepartmentRepository departmentRepository) {
//		this.departmentRepository = departmentRepository;
//	}

	public Department save(Department department) {
		if (department.getId() != null && departmentRepository.existsById(department.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return departmentRepository.save(department);
	}

	public Department update(Department department) {
		if (department.getId() != null && !departmentRepository.existsById(department.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return departmentRepository.save(department);
	}

	

	public Department findOne(Integer id) {
		return departmentRepository.findById(id).orElseThrow();
	}

	public void delete(Integer id) {
		departmentRepository.deleteById(id);
	}
}
