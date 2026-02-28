package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import exception.InvalidStudentException;
import model.Student;

public class MysqlDAO implements StudentDAO{

	public void addNewStudent(Connection connection,int id, String name, String emailId, int age, long mobileNumber) throws InvalidStudentException{
		
		if(name.length()==0) {
			throw new InvalidStudentException("Name can't be null");
		}
		if(!emailId.contains("@")) {
			throw new InvalidStudentException("Emailid must contain @");
		}
		if(age<0) {
			throw new InvalidStudentException("Age must not be negative");
		}
		int count=0;
		long number= mobileNumber;
		while(mobileNumber>0) {
			count++;
			mobileNumber/=10;
		}
		if(count!=10) {
			throw new InvalidStudentException("Mobile number must be of 10 numbers");

		}
		
		String insert = "insert into student_details values(?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			 int indexposition=1;
			 preparedStatement.setInt(indexposition++, id);
			 preparedStatement.setString(indexposition++, name);
			 preparedStatement.setString(indexposition++, emailId);
			 preparedStatement.setInt(indexposition++, age);
			 preparedStatement.setLong(indexposition++, number);
			 
			 preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void viewAllStudents(Connection connection) {
		
		String select = "select * from student_details";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(select);
			
			ResultSet resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
			System.out.println("-----------------------");
			System.out.println("Student Id: "+resultset.getInt("Student_id"));
			System.out.println("Student Name: "+resultset.getString("Student_Name"));
			System.out.println("Student EmailId: "+resultset.getString("Student_email"));
			System.out.println("Student Age: "+resultset.getInt("Student_age"));
			System.out.println("Student Mobile Number: "+resultset.getLong("Student_mobile_number"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateStudent(Connection connection,long mobileNumber, String emailId) {
		String update = "update student_details set Student_email=? where Student_mobile_number=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(update);
			
			preparedStatement.setString(1, emailId);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteStudent(Connection connection,int id) {
		
		String delete = "delete from student_details where Student_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}


}
