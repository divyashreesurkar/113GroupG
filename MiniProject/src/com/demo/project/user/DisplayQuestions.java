package com.demo.project.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.demo.project.admin.QuestionList;
import com.demo.project.databaseconnection.DBUtil;

public class DisplayQuestions {

	public static void displayShuffledQuestions() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your student ID: ");
		int studentId = sc.nextInt();

		if (checkStudentId(studentId)) {
			List<QuestionList> questionList = getQuestionListFromDatabase();
			shuffleQuestions(questionList);
			int correctAnswers = displayQuestions(questionList);
			storeQuizResult(studentId, correctAnswers);
		} else {
			System.out.println("Invalid student ID. Please enter a valid ID.");
		}
	}

	public static boolean checkStudentId(int studentId) {
		Connection con = DBUtil.getCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM student WHERE id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, studentId);
			rs = pst.executeQuery();

			boolean validId = rs.next();

			return validId;
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

		return false;
	}

	public static List<QuestionList> getQuestionListFromDatabase() {
		List<QuestionList> questionList = new ArrayList<>();
		Connection con = DBUtil.getCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String query = "SELECT Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer FROM questionlist";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				String questionText = rs.getString("Question");
				String optionA = rs.getString("OptionA");
				String optionB = rs.getString("OptionB");
				String optionC = rs.getString("OptionC");
				String optionD = rs.getString("OptionD");
				String correctAnswer = rs.getString("CorrectAnswer");

				QuestionList question = new QuestionList(questionText, optionA, optionB, optionC, optionD,
						correctAnswer);
				questionList.add(question);
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

		return questionList;
	}

	public static void shuffleQuestions(List<QuestionList> questionList) {
		Collections.shuffle(questionList);
	}

	public static int displayQuestions(List<QuestionList> questionList) {
		int correctAnswers = 0;
		for (int i = 0; i < questionList.size(); i++) {
			QuestionList question = questionList.get(i);
			System.out.println("Question " + (i + 1) + ":");
			System.out.println(question.getQuestion());
			System.out.println("Option A: " + question.getOptionA());
			System.out.println("Option B: " + question.getOptionB());
			System.out.println("Option C: " + question.getOptionC());
			System.out.println("Option D: " + question.getOptionD());

			boolean validOption = false;
			String input;
			do {
				System.out.print("Enter the correct option: ");
				Scanner sc = new Scanner(System.in);
				input = sc.next();

				if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B") || input.equalsIgnoreCase("C")
						|| input.equalsIgnoreCase("D")) {
					validOption = true;
				} else {
					System.out.println("Invalid option. Please enter a valid option (A, B, C, or D).");
				}

			} while (!validOption);
			if (input.equalsIgnoreCase(question.getCorrectAnswer())) {
				correctAnswers++;
				System.out.println("Correct!");
			} else {
				System.out.println("Incorrect!");
			}

			System.out.println();
		}

		System.out.println("\t\t\t ***Test Over***");
		System.out.println();

		return correctAnswers;
	}

	public static void storeQuizResult(int studentId, int correctAnswers) {
		Connection con = DBUtil.getCon();
		PreparedStatement pst = null;
		try {
			String query = "INSERT INTO studentscore (id, score) VALUES (?, ?)";
			pst = con.prepareStatement(query);
			pst.setInt(1, studentId);
			pst.setInt(2, correctAnswers);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Quiz Result: Student Id = " + studentId + ", Final Score = " + correctAnswers);
			} else {
				System.out.println("Failed to store quiz result.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null || pst != null) {
				try {
					con.close();
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
