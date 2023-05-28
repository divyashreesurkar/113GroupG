package com.demo.project.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.demo.project.databaseconnection.DBUtil;

public class QuizResult {

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
			String query = "SELECT s.id, s.firstname, s.lastname, sc.score " + "FROM student s "
					+ "INNER JOIN studentscore sc ON s.id = sc.id";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				int score = rs.getInt("score");
				StudentEntry student = new StudentEntry(id, firstName, lastName);
				StudentScore studentScore = new StudentScore(student, score);
				studentScores.add(studentScore);
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
		return studentScores;
	}

	private static void displayStudentScores(List<StudentScore> studentScores) {
		Collections.sort(studentScores, new StudentScoreComparator());
		int rank = 1;
		for (StudentScore studentScore : studentScores) {
			System.out.println("Rank: " + rank);
			System.out.println("Student Name: " + studentScore.getStudent().getFname() + " "
					+ studentScore.getStudent().getLname());
			System.out.println("ID: " + studentScore.getStudent().getId());
			System.out.println("Score: " + studentScore.getScore());
			System.out.println();
			rank++;
		}
	}

}
