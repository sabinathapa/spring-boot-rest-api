# spring-boot-rest-api
Simple REST API template Project using Spring Boot, Hibernate, Spring boot security, and MySQL Database. 
Plus Vue js project as a client.
  (we might change vue js client application with React(typeScript))

# Prerequisities
- MySQL Server / Database
- MySql Workbench
- IDE (Intellij) / VS Code for frontend
- Tomcat Server

# things to do to run the application in your local machine
 
 ## Update Project properties file
 - Path src\main\resources
 - Update Local mysql database configuration to map with your database
    ```xml
      datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      datasource.url= jdbc:mysql://localhost/sabina
      datasource.username= thpsabina
      datasource.password= UrbiSabina254
    ```
- Update Hibernate configuration.
    ```xml
        hibernate.hbm2ddl.auto=create
    ```
