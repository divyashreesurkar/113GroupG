package com.demo.project.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.demo.project.databaseconnection.DBUtil;
import com.demo.project.user.StudentEntry;
import com.demo.project.user.StudentScore;
import com.demo.project.user.StudentScoreComparator;

public class StudentScoreList {

	public static void details() {
		List<StudentScore> studentScores = fetchStudentScores();
		displayStudentScores(studentScores);
	}

	private static List<StudentScore> fetchStudentScores() {
		List<StudentScore> studentScores = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getCon();
			String query = "SELECT s.id, s.FirstName, s.LastName, s.StudentUsername, s.StudentPassword, s.City, s.MailId, s.MobileNumber, sc.Score "
					+ "FROM student s " + "INNER JOIN studentscore sc ON s.id = sc.id";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				// Retrieve the data from the result set
				int id = rs.getInt("id");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String username = rs.getString("StudentUsername");
				String password = rs.getString("StudentPassword");
				String city = rs.getString("City");
				String mailid = rs.getString("MailId");
				Long mobile = rs.getLong("MobileNumber");
				int score = rs.getInt("Score");

				StudentEntry student = new StudentEntry(id, firstName, lastName, username, password, city, mailid,
						mobile);
				StudentScore studentScore = new StudentScore(student, score);

				studentScores.add(studentScore);
			}

			studentScores.sort(Comparator.comparingInt(s -> s.getStudent().getId()));
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
		return studentScores;
	}

	private static void displayStudentScores(List<StudentScore> studentScores) {
		StudentScoreComparator comparator = new StudentScoreComparator();
		studentScores.sort(Comparator.comparingInt(s -> s.getStudent().getId())); // Sort the list based on ID in
																					// ascending order
		for (StudentScore studentScore : studentScores) {
			// Display student details
			System.out.println("ID: " + studentScore.getStudent().getId());
			System.out.println("Student Name: " + studentScore.getStudent().getFname() + " "
					+ studentScore.getStudent().getLname());
			System.out.println("Username: " + studentScore.getStudent().getSusername());
			System.out.println("Password: " + studentScore.getStudent().getSpassword());
			System.out.println("City: " + studentScore.getStudent().getCity());
			System.out.println("MailId: " + studentScore.getStudent().getMailId());
			System.out.println("Mobile Number: " + studentScore.getStudent().getMobileNumber());
			System.out.println("Score: " + studentScore.getScore());
			System.out.println();
		}
	}

}
