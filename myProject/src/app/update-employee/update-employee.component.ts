import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  departments: Department[];
  managers: Employee[];  
  id: number;
  //employee: Employee;
  constructor(private employeeService: EmployeeService,private departmentService: DepartmentService,
    private route: ActivatedRoute,private router: Router) { }
  // constructor(private route: ActivatedRoute,private router: Router,
  //   private employeeService: EmployeeService,) { }

  ngOnInit() {
    
    this.listDepartments();
    this.listEmployees();
    this.employee = new Employee();
    this.id = this.route.snapshot.params['id'];
    
    this.employeeService.getEmployee(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }



  listDepartments() {
    this.departmentService.getDepartmentList().subscribe(
      data => {
        console.log('Departments' + JSON.stringify(data));
        this.departments = data;
      }
    );
    
  
  }
  
  listEmployees() {
    this.employeeService.getEmployeesList().subscribe(
      data => {
        console.log('Managers' + JSON.stringify(data));
        this.managers = data;
      }
    );
  }

  updateEmployee() {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(data => {
        console.log(data);
        this.employee = new Employee();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}