package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.GapContent;

public class StudentCRUD {
	
	public Connection getConnection() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?user=postgres&password=root");
		return connection;
	}

	public void insertStudent(Student student) {
		try {
			Connection connection =getConnection();
			Statement statement=connection.createStatement();
			
			PreparedStatement preparedstatement = connection
					.prepareStatement("insert into student values(?,?,?,?)");
			preparedstatement.setInt(1, student.getId());
			preparedstatement.setString(2, student.getName());
			preparedstatement.setInt(3, student.getAge());
			preparedstatement.setInt(4, student.getMarks());
			
			preparedstatement.execute();
			connection.close();
			System.out.println("data inserted succesfuly");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) {
		try {
			Connection connection =getConnection();
			Statement statement=connection.createStatement();
			PreparedStatement preparedstatement = connection
					.prepareStatement("update student set name=? where id=? ");
			preparedstatement.setInt(2, student.getId());
			preparedstatement.setString(1, student.getName());
			preparedstatement.execute();
			connection.close();
			System.out.println("data updated succesfuly");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteStudent(Student student) {
		try {
			Connection connection =getConnection();
			Statement statement=connection.createStatement();
			PreparedStatement preparedstatement = connection.prepareStatement("delete from student where id=? ");
			preparedstatement.setInt(1, student.getId());
			preparedstatement.execute();
			connection.close();
			System.out.println("data deleted succesfuly");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getStudent(Student student) {
		try {
			Connection connection =getConnection();

			Statement statement=connection.createStatement();
			String query = "select * from student";
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name= rs.getString(2);
				int age = rs.getInt(3);
				int marks= rs.getInt(4);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(age);
				System.out.println(marks);
				System.out.println("======================");
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
