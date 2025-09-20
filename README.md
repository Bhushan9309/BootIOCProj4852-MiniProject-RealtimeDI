This project demonstrates the core concepts of Spring Boot IoC (Inversion of Control) and Dependency Injection (DI) through a real-time example of an Employee Management System.

It follows a 3-layer architecture:

Controller Layer (EmployeeOperationsController) – handles user requests (designations) and delegates processing to the service layer.

Service Layer (EmployeeMgmtServiceImpl) – applies business logic such as converting designations to uppercase and calculating gross/net salaries.

DAO Layer (EmployeeDAOImpl) – interacts with the database using Spring JDBC + DataSource to fetch employees based on their designations.

The Employee model represents each employee with details (ID, name, designation, salary) and computed fields (gross salary, net salary).

Database configuration is externalized in application.properties, allowing Spring Boot to auto-configure the DataSource.
