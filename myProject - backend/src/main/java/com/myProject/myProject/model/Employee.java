package com.myProject.myProject.model;

import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;


@Entity
@Table
public class Employee {
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty(message = "First name must not be empty")
	@Length(min = 2, message = "First Name required minumum 2 character.")
	private String firstName;
	
	@NotNull
	@NotEmpty(message = "Last name must not be empty")
	@NotBlank
	@Length(min = 2, message = "Last Name required minumum 2 character.")
	private String lastName;
	
	@Pattern(regexp="(?:\\d{3}-){2}\\d{4}")
	private String phone;
	
	@Min(value = 1,message="Salary should be greater than 0")
	private long salary;
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")	
	private Department department;
	
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
	 private Employee manager;

	 @OneToMany(
	        cascade = {CascadeType.ALL},
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	 )
	 @JoinColumn(name = "manager_id")
	 private List<Employee> children;

	
	public Employee(@NotNull @NotBlank @Length(min = 1, max = 2) String firstName, Employee manager) {
		this.firstName = firstName;
		this.manager = manager;
	}	
	public Employee() {
	}

	public Integer  getId() {
        return id;
    }
    public void setId(int  id) {
        this.id = id;
    }
    
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	


}
