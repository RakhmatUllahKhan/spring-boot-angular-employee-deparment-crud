package com.myProject.myProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myProject.myProject.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}
