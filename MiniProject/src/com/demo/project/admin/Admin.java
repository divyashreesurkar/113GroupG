package com.demo.project.admin;

import java.util.Scanner;

import com.demo.project.exceptionhandler.ExceptionHandler;

public class Admin {

	public static void getAdmin() {
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("-------------MENU CARD-------------");
			System.out.println("1. List of students with score");
			System.out.println("2. Student score by using id");
			System.out.println("3. Add question");
			System.out.println("4. Exit ");
			System.out.println("-----------------------------------");

			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter your choice : ");
				int choice = validateInput(sc);

				switch (choice) {
				case 1:
					StudentScoreList.details();
					break;
				case 2:
					StudentDetailsById.getDetailsById();
					break;
				case 3: 
					AddQuestion.addQuestion();
					break;
				case 4:
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
