
Note:Springboot Backend to expose api use following json
For user with Postman/Swagger/
1-First Save Department without manager
{
    "name":"spring boot"
}
{
    "name":"angular"
}
2- save employee with department
{
    "firstName":"rakhmat ullah",
    "lastName":"khan",
    "phone":"123-456-7890",
    "salary":150000,
    "department":
        {
            "id":1           
        } 

}
3- save employee with manager

{
    "firstName":"rakhmat ullah",
    "lastName":"khan",
    "phone":"123-456-7890",
    "salary":150000,
    "department":
        {
            "id":1           
        },
    "manager":
        {
            "id":1           
        } 

}
4 Save Department with manager
{
    "name":"spring boot",
     "managers":{
		"id":1
      }
}