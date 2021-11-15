package com.myProject.myProject.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotBlank
	private String name;
	
	@OneToMany(mappedBy="department")
	private List<Employee> employee;	 
	
	@ManyToOne
	@JoinColumn(name = "manager_id",referencedColumnName = "employee_id")
	private Employee managers;
	
	
	public Department() {
	}
	public Department(String name) {
		this.name = name;
	}
	public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Employee getManagers() {
		return managers;
	}
	public void setManagers(Employee managers) {
		this.managers = managers;
	}

}
