
import { Observable } from "rxjs";
import { Employee } from "../employee";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { EmployeeService } from "../employee.service";
import { DepartmentService } from "../department.service";
import { Department } from "../department";

@Component({
  selector: "app-employee",
  templateUrl: "./employee.component.html",
  styleUrls: ["./employee.component.css"]
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]>;
  departments: Department[];


  constructor(private employeeService: EmployeeService,private departmentService: DepartmentService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateEmployee(id: number){
    this.router.navigate(['update', id]);
  }

  listDepartments() {
    this.departmentService.getDepartmentList().subscribe(
      data => {
        console.log('Departments' + JSON.stringify(data));
        this.departments = data;
      }
    );
  }
 }