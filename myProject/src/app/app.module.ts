import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './add-employee/add-employee.component';
import { EmployeeListComponent } from './employee/employee.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }