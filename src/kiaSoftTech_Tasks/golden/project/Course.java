package kiaSoftTech_Tasks.golden.project;

public class Course {
	private int id;
	private String name;
	private int teacherId;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String name, int teacherId) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

}
