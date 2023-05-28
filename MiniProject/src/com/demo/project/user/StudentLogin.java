package com.demo.project.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.demo.project.databaseconnection.DBUtil;

public class StudentLogin {

	public static void getStudent() {

		System.out.println("\t\t\t Student Login");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Username : ");
		String inputUsername = sc.next();
		System.out.print("Enter Password : ");
		String inputPassword = sc.next();

		boolean validCredentials = checkCredentials(inputUsername, inputPassword);

		if (validCredentials) {

			System.out.println("Access granted! You can proceed with further operations.");
			UserFunctionalities.getUserFunctionalities();

		} else {

			System.out.println("Invalid username or password. Please enter valid credentials.");
		}
	}

	public static boolean checkCredentials(String inputUsername, String inputPassword) {
		Connection con = DBUtil.getCon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = DBUtil.getCon();

			String query = "SELECT StudentUsername, StudentPassword FROM student WHERE StudentUsername = ? AND  StudentPassword= ?";
			pst = con.prepareStatement(query);
			pst.setString(1, inputUsername);
			pst.setString(2, inputPassword);

			rs = pst.executeQuery();

			if (rs.next()) {

				return true;
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

		return false;
	}

}
