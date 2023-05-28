package com.demo.project.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.project.databaseconnection.DBUtil;

public class StudentRegistration {

	public static void studentRegister() {
		System.out.println("\t\t\t Student Registration Form");
		Connection con = DBUtil.getCon();
		String query = "insert into student values (?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Id : ");
			int id = sc.nextInt();
			System.out.print("Enter First Name : ");
			String FirstName = sc.next();
			System.out.print("Enter Last Name : ");
			String LastName = sc.next();
			System.out.print("Enter Username : ");
			String StudentUsername = sc.next();
			System.out.print("Enter Password : ");
			String StudentPassword = sc.next();
			System.out.print("Enter City : ");
			String City = sc.next();
			System.out.print("Enter Mail Id : ");
			String MailId = sc.next();
			System.out.print("Enter Mobile Number : ");
			Long MobileNumber = sc.nextLong();

			List<StudentEntry> studentlist = new ArrayList<StudentEntry>();
			StudentEntry se = new StudentEntry(id, FirstName, LastName, StudentUsername, StudentPassword, City, MailId,
					MobileNumber);
			studentlist.add(se);

			pst.setInt(1, id);
			pst.setString(2, FirstName);
			pst.setString(3, LastName);
			pst.setString(4, StudentUsername);
			pst.setString(5, StudentPassword);
			pst.setString(6, City);
			pst.setString(7, MailId);
			pst.setLong(8, MobileNumber);

			pst.executeUpdate();

			System.out.println("\t\t\t Student Record inserted successfully.");

		} catch (SQLException e) {
			System.out.println("Student registration failed");
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

