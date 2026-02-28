package com;
import DAO.MysqlDAO;
import exception.InvalidStudentException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id: ");
		int student_id = sc.nextInt();
		System.out.println("Enter student name: ");
		String student_Name = sc.next();
		sc.nextLine();
		System.out.println("Enter student emailId: ");
		String student_email = sc.next();
		System.out.println("Enter student age: ");
		int student_age = sc.nextInt();
		System.out.println("Enter student mobile: ");
		long student_mobile_number = sc.nextLong();
    	
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management?user=root&password=Root");

	            MysqlDAO mysqlDAO = new MysqlDAO();

	            while (true) {
	                System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
	                System.out.println("1. Add New Student");
	                System.out.println("2. View All Students");
	                System.out.println("3. Delete Student");
	                System.out.println("4. Update Student");
	                System.out.println("5. Exit");
	                System.out.print("Enter your choice: ");
	                
	                int choice = sc.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter student id: ");
	                        int id = sc.nextInt();
	                        System.out.print("Enter student name: ");
	                        String name = sc.nextLine();
	                        System.out.print("Enter student emailId: ");
	                        String email = sc.next();
	                        System.out.print("Enter student age: ");
	                        int age = sc.nextInt();
	                        System.out.print("Enter student mobile: ");
	                        long mobile = sc.nextLong();

	                        mysqlDAO.addNewStudent(connection, id, name, email, age, mobile);
	                        System.out.println("Student added successfully!");
	                        break;

	                    case 2:
	                        mysqlDAO.viewAllStudents(connection);
	                        break;

	                    case 3:
	                        System.out.print("Enter student ID to delete: ");
	                        int deleteId = sc.nextInt();
	                        mysqlDAO.deleteStudent(connection, deleteId);
	                        break;

	                    case 4:
	                        System.out.print("Enter student Mobile Number to update: ");
	                        long mobileNumber = sc.nextLong();
	                        sc.nextLine(); 
	                        System.out.print("Enter new emailId: ");
	                        String emailId = sc.next();

	                        mysqlDAO.updateStudent(connection, mobileNumber, emailId); 
	                        break;

	                    case 5:
	                        System.out.println("Exit");
	                        connection.close();
	                        System.exit(0);

	                    default:
	                        System.out.println("Invalid ");
	                }
	            }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidStudentException e) {
			e.printStackTrace();
		}

		

    }
}
