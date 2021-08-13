# spring-boot-rest-api
Simple REST API template Project using Spring Boot, Hibernate, Spring boot security, and MySQL Database. 
Plus Vue js project as a client.
  (we might change vue js client application with React(typeScript))

# Prerequisities
- MySQL Server / Database
- MySql Workbench
- IDE (Intellij) / VS Code for frontend
- Tomcat Server
- Postman

# things to do run this application in your local machine

## Setup the application 
 
 ### Update Project properties file
 - Path src\main\resources
 - Update Local mysql database configuration to map with your database
    ```xml
      datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      datasource.url= jdbc:mysql://localhost/<your-database>
      datasource.username= <database-username>
      datasource.password= <database-password>
    ```
- Update Hibernate configuration.
    ```xml
        hibernate.hbm2ddl.auto=create
    ```
 
 ## Setup the User
 - Create new user 
 - Make a POST request to this url (Port can be different, depending upon your localhost setup)
      http://localhost:8080/api/auth/register
      Body
      ```json
        {
           "username": "<username>",
           "password": "<password>"
        }
      ```
