### Employee Management System

Overview

The Employee Management System is a Spring Boot project that demonstrates the use of Spring's @Transactional annotation for managing database transactions effectively. This system consists of three primary entities: Employee, Department, and MetaInfo. The EmployeeService class provides a method to add an employee while ensuring data integrity and consistency through transactional operations.

### Entity Classes

Employee: Represents an employee entity with relevant details.

Department: Represents the department an employee belongs to.

MetaInfo: Stores additional metadata related to an employee.

### Testing Scenarios

The following scenarios can be tested using a MySQL database and debugging tools to observe transactional behavior:

Scenario 1: Successful Transaction

Add an employee with valid data.

Verify that the department, employee, and meta information are successfully saved in the database.

Scenario 2: Empty Employee Name

Attempt to add an employee with an empty name.

Expect an EmptyInputException to be thrown.

Ensure that no data is saved in the database due to transaction rollback.

Scenario 3: Department Save Failure

Simulate a failure in the saveDepartmentWithTransaction method (e.g., by throwing an exception).

Confirm that no data is saved in the database due to transactional rollback.

Scenario 4: MetaInfo Save Failure

Simulate a failure in the saveMetaInfo method (e.g., by throwing an exception).

Verify that the department and employee are saved, but the meta information is not, demonstrating the transactional boundaries.

### Conclusion

This project highlights the importance of Spring's @Transactional annotation in managing transactions across multiple service methods. By testing different scenarios, you can observe how transaction propagation strategies impact data consistency and integrity.

### Additional Considerations

Experiment with different transaction propagation strategies to understand their effects.

Use Spring Boot logging and debugging tools to trace transaction rollbacks and commits.

