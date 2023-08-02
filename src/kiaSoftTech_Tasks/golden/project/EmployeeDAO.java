package kiaSoftTech_Tasks.golden.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/kiasoft";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}

	public void addEmployee(Employee employee) {
		try (Connection con = getConnection();

				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO kiasoft.employees (eid, ename, designation, salary) VALUES (?,?, ?, ?)")) {
			ps.setInt(1, employee.getEid());
			ps.setString(2, employee.getEname());
			ps.setString(3, employee.getDesignation());
			ps.setDouble(4, employee.getSalary());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM kiasoft.employees");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEid(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setDesignation(rs.getString("designation"));
				employee.setSalary(rs.getDouble("salary"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public void updateEmployee(Employee employee) {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"UPDATE kiasoft.employees SET ename=?, designation=?, salary=? WHERE eid=?")) {
			stmt.setString(1, employee.getEname());
			stmt.setString(2, employee.getDesignation());
			stmt.setDouble(3, employee.getSalary());
			stmt.setInt(4, employee.getEid());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM kiasoft.employees WHERE eid=?")) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
