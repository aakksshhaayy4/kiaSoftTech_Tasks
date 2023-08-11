package kiaSoftTech_Tasks.golden.project;

import java.util.List;

public class SchoolMain {
	public static void main(String[] args) {
		SchoolManagementDAO dao = new SchoolManagementDAO();

		// Add students
//		Student student1 = new Student();
//		student1.setId(0);
//		student1.setName("John Doe");
//		student1.setAge(15);
//		student1.setGrade("10th");
//		dao.addStudent(student1);

		Student student2 = new Student();
		student2.setId(4);
		student2.setName("Jane Smith");
		student2.setAge(14);
		student2.setGrade("9th");
		dao.addStudent(student2);

		System.out.println("----------------get All students--------------");
		// Get all students
		List<Student> students = dao.getAllStudents();
		for (Student student : students) {
			System.out.println(student.getName() + " | " + student.getAge() + " | " + student.getGrade());
		}

		System.out.println("----------------update students--------------");
		// Update an employee
		Student studentToUpdate = students.get(4);
		studentToUpdate.setAge(23);
		dao.updateStudent(studentToUpdate);

		System.out.println("----------------delete student--------------");
		// Delete an employee
		int studnetIdToDelete = students.get(1).getId();
		dao.deleteStudent(studnetIdToDelete);

	}
}
