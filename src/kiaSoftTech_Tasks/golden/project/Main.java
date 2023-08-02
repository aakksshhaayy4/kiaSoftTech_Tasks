package kiaSoftTech_Tasks.golden.project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {

		EmployeeDAO dao = new EmployeeDAO();
//
//		Connection connection = dao.getConnection();
//
//		Statement statement = connection.createStatement();
//		statement.execute("CREATE TABLE employee(ename, designation, salary)");

		// Add an employee
		Employee emp1 = new Employee();
		emp1.setEname("Joe Disuza");
		emp1.setDesignation("UI Engineer");
		emp1.setSalary(50000.0);
		dao.addEmployee(emp1);

		System.out.println("----------------get all employees--------------");
		// Get all employees
		List<Employee> employees = dao.getAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp.getEname() + " | " + emp.getDesignation() + " | " + emp.getSalary());
		}

		System.out.println("----------------update employee--------------");
		// Update an employee
		Employee empToUpdate = employees.get(0);
		empToUpdate.setDesignation("Senior Software Engineer");
		dao.updateEmployee(empToUpdate);

		System.out.println("----------------delete employee--------------");
		// Delete an employee
		int employeeIdToDelete = employees.get(1).getEid();
		dao.deleteEmployee(employeeIdToDelete);
	}

}
