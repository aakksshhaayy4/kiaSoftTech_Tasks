package kiaSoftTech_Tasks.golden.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolManagementDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/kiasoft";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	}

	public void addStudent(Student student) {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO students (id,name, age, grade) VALUES (?,?, ?, ?)")) {
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.setInt(3, student.getAge());
			stmt.setString(4, student.getGrade());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setGrade(rs.getString("grade"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public void updateStudent(Student student) {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"UPDATE kiasoft.students SET name=?, age=?, grade=? WHERE id=?")) {
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getAge());
			stmt.setString(3, student.getGrade());
			stmt.setInt(4, student.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM kiasoft.students WHERE id=?")) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
