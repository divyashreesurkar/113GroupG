package com.demo.project.user;

import java.util.Scanner;

import com.demo.project.exceptionhandler.ExceptionHandler;

public class UserFunctionalities {

	public static void getUserFunctionalities() {
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("-------------MENU CARD-------------");
			System.out.println("1. Start Test");
			System.out.println("2. Quiz result");
			System.out.println("3. Exit ");
			System.out.println("-----------------------------------");

			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter your choice : ");
				int choice = validateInput(sc);

				switch (choice) {
				case 1:
					DisplayQuestions.displayShuffledQuestions();
					break;
				case 2:
					QuizResult.details();
					break;
				case 3:
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
