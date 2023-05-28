package com.demo.project;

import java.util.Scanner;

import com.demo.project.admin.Admin;
import com.demo.project.exceptionhandler.ExceptionHandler;
import com.demo.project.user.User;

public class Main {

	static {
		System.out.println("\t\t ***Welcome to G's Group Quiz Application Project***");
	}

	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("-------------MENU CARD-------------");
			System.out.println("1. User");
			System.out.println("2. Admin");
			System.out.println("3. Exit ");
			System.out.println("-----------------------------------");

			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter your choice : ");
				int choice = validateInput(sc);

				switch (choice) {
				case 1:
					User.getUser();
					break;
				case 2:
					Admin.getAdmin();
					break;
				case 3:
					System.out.println("\t\t\t ***Thank You...Visit Again***");
					flag = false;
					break;
				default:
					System.out.println("Invalid Option");
					break;
				}
			} catch (ExceptionHandler e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private static int validateInput(Scanner sc) throws ExceptionHandler {
		if (sc.hasNextInt()) {
			return sc.nextInt();
		} else {
			sc.next();
			throw new ExceptionHandler("Invalid input. Please enter a valid number.");
		}
	}
}

