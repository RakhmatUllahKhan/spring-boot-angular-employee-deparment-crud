import { Department } from "./department";

export class Employee {
    public id:number;
    public firstName:string;
    public lastName:string;
    public phone:string;
    public salary:number;
    
    public department:Department;
    public manager:Employee;

    
}