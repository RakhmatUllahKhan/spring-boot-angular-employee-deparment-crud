import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Department } from '../department';
import { Observable } from 'rxjs/internal/Observable';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  departments: Department[];
  id=0;

  managers: Employee[];
  submitted = false;


  constructor(private employeeService: EmployeeService,private departmentService: DepartmentService,
    private router: Router) { }

    ngOnInit() {
      this.listDepartments();
      this.listEmployees();
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
  
 

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  save() {
   // this.id =(Number)this.employee.department;
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log("save data="+data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/employees']);
  }
}