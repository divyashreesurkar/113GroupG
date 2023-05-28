package com.demo.project.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.project.databaseconnection.DBUtil;

public class AddQuestion {

	public static void addQuestion() {

		Connection con = DBUtil.getCon();
		PreparedStatement pst = null;
		try {
			String query = "insert into questionlist values (?,?,?,?,?,?)";
			pst = con.prepareStatement(query);

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Question : ");
			String Question = sc.nextLine();
			System.out.print("Enter Option A : ");
			String OptionA = sc.nextLine();
			System.out.print("Enter Option B : ");
			String OptionB = sc.nextLine();
			System.out.print("Enter Option C : ");
			String OptionC = sc.nextLine();
			System.out.print("Enter Option D : ");
			String OptionD = sc.nextLine();
			System.out.print("Enter Correct Option : ");
			String CorrectAnswer = sc.next();

			pst.setString(1, Question);
			pst.setString(2, OptionA);
			pst.setString(3, OptionB);
			pst.setString(4, OptionC);
			pst.setString(5, OptionD);
			pst.setString(6, CorrectAnswer);

			List<QuestionList> questionList = new ArrayList<>();
			QuestionList qs = new QuestionList(Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer);
			questionList.add(qs);

			pst.executeUpdate();

			System.out.println("\t\t\t  Question Added successfully.");
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
	
	
	
	

