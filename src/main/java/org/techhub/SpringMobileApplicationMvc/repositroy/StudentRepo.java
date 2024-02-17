package org.techhub.SpringMobileApplicationMvc.repositroy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.techhub.SpringMobileApplicationMvc.model.Student;

@Repository("studentRepo")
public class StudentRepo {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	public StudentRepo() // constuctor
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql", "root", "root");
			System.out.println(conn);
		} catch (Exception ex) {
			System.out.println("Error" + ex);

		}
	}
	// add student record

	public boolean AddStudent(Student s) {
		try {
			stmt = conn.prepareStatement("insert into register_tbl values('0',?,?,?,?,?,?)");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getContact());
			stmt.setString(4, "");
			stmt.setString(5, "");
			stmt.setString(6, "");

			int val = stmt.executeUpdate();
			System.out.println(val);
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("error is " + ex);
		}
		return false;

	}

	// view all records
	public List<Student> viewStudent() {
		try {
			List<Student> list = new ArrayList<Student>();
			stmt = conn.prepareStatement("select *from register_tbl");
			rs = stmt.executeQuery();
			while (rs.next()) {

				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContact(rs.getString(4));

				list.add(s);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Error" + ex);
		}
		return null;

	}

	// delete from operation
	public boolean delRecord(int userId) {

		try {
			stmt = conn.prepareStatement("delete from register_tbl where id=?");
			stmt.setInt(1, userId);
			int val = stmt.executeUpdate();
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error" + ex);
			return false;
		}

	}

	// update record
	public boolean update(Student student) {
		try {
			stmt = conn.prepareStatement("update register_tbl set Name=?,Email=?,Contact=? where id=?");
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getContact());
			stmt.setInt(4, student.getId());
			int val = stmt.executeUpdate();
			if (val > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Error" + ex);
			return false;
		}

	}

	public List<Student> searchStudent(String name) {
		List<Student> list = new ArrayList<Student>();
		try {
			stmt = conn.prepareStatement("select *from register_tbl where name=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContact(rs.getString("contact"));
				list.add(s);
			}

		} catch (Exception ex) {
			System.out.println("Error" + ex);
		}
		return list;

	}

	public boolean validateEmail(Student students) {
		boolean validateEmailStatus = false;
		try {
			stmt = conn.prepareStatement("SELECT * FROM register_tbl WHERE email = ?");
			stmt.setString(1, students.getEmail());
			rs = stmt.executeQuery();
			if (rs.next()) {
				return validateEmailStatus;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return validateEmailStatus = true;
	}
}
