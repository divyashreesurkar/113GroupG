package com.demo.project.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.project.databaseconnection.DBUtil;
import com.demo.project.user.StudentEntry;
import com.demo.project.user.StudentScore;

public class StudentDetailsById {

	public static void getDetailsById() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the student ID: ");
		int studentId = sc.nextInt();

		StudentEntry se = fetchStudentDetails(studentId);
		if (se != null) {
			System.out.println("Student Details:");
			System.out.println("ID: " + se.getId());
			System.out.println("First Name: " + se.getFname());
			System.out.println("Last Name: " + se.getLname());
			System.out.println("Username: " + se.getSusername());
			System.out.println("Password: " + se.getSpassword());
			System.out.println("City: " + se.getCity());
			System.out.println("Mail ID: " + se.getMailId());
			System.out.println("Mobile: " + se.getMobileNumber());

			StudentScore studentScore = fetchStudentScore(studentId);
			if (studentScore != null) {
				System.out.println("Score: " + studentScore.getScore());
			} else {
				System.out.println("Score not found for the student.");
			}
		} else {
			System.out.println("Student not found with the provided ID.");
		}
	}

	private static StudentEntry fetchStudentDetails(int studentId) {
		StudentEntry se = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getCon();
			String query = "SELECT s.id, s.FirstName, s.LastName, s.StudentUsername, s.StudentPassword, s.City, s.MailId, s.MobileNumber "
					+ "FROM student s " + "WHERE s.id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, studentId);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String username = rs.getString("StudentUsername");
				String password = rs.getString("StudentPassword");
				String city = rs.getString("City");
				String mailid = rs.getString("MailId");
				long mobile = rs.getLong("MobileNumber");
				se = new StudentEntry(id, firstName, lastName, username, password, city, mailid, mobile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null || pst != null || rs != null) {
				try {
					rs.close();
					con.close();
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return se;
	}

	private static StudentScore fetchStudentScore(int studentId) {
		StudentScore studentScore = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getCon();
			String query = "SELECT id, score " + "FROM studentscore " + "WHERE id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, studentId);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				int score = rs.getInt("score");
				StudentEntry studentEntry = new StudentEntry(studentId, "", "");

				studentScore = new StudentScore(studentEntry, score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null || pst != null || rs != null) {
				try {
					rs.close();
					con.close();
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentScore;
	}

	public static void main(String[] args) {
		getDetailsById();
	}
}
