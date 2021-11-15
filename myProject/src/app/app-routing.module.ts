import { CreateEmployeeComponent } from './add-employee/add-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee/employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'addemployee', component: CreateEmployeeComponent },
  { path: 'update/:id', component: UpdateEmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }