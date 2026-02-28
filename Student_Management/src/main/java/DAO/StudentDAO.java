package DAO;

import java.sql.Connection;

import com.mysql.cj.protocol.Resultset;

import exception.InvalidStudentException;
import model.Student;

public interface StudentDAO {
	
	void addNewStudent(Connection connection,int id, String name, String emailId, int age, long mobileNumber) throws InvalidStudentException;
	
	void viewAllStudents(Connection connection);
	
	void updateStudent(Connection connection,long mobileNumber, String emailId);
	
	void deleteStudent(Connection connection,int id);

}
