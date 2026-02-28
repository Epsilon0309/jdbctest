package model;

public class Student {
	
	private  int student_id;
	private  String student_name;
	private  String student_email;
	private  int student_age;
	private  long student_mobie_number;
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public int getStudent_age() {
		return student_age;
	}
	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}
	public long getStudent_mobie_number() {
		return student_mobie_number;
	}
	public void setStudent_mobie_number(long student_mobie_number) {
		this.student_mobie_number = student_mobie_number;
	}
	
	public Student() {
		super();
	}
	public Student(int student_id, String student_name, String student_email, int student_age,
			long student_mobie_number) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_age = student_age;
		this.student_mobie_number = student_mobie_number;
	}
	
	

}
