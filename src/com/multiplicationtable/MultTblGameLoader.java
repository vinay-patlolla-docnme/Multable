package com.multiplicationtable;

import java.util.Scanner;

public class MultTblGameLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Multiplication Game by Liberty Page! \n"
				+ "Pick your multiplication Table (2 to 12): ");
		int questionsCount = 0;
		int multiplicationTable = scanner.nextInt();
		MultTblGame mlGame = new MultTblGame(multiplicationTable);

		while (questionsCount < 25 && mlGame.getFactorListSize() > 0) {

			int randomFactor = mlGame.getRandomFactor();

			System.out.println("What is " + multiplicationTable + "×" + randomFactor);

			int userAnswer = scanner.nextInt();

			if (mlGame.checkAnswer(mlGame.getCurrentRandomIndex(), userAnswer)) {
				System.out.println("Correct, you have " + mlGame.getNoOfCorrectAnswers() + " right answer/answers!");
			} else {
				System.out.println("Sorry, try again. You have " + mlGame.getNoOfCorrectAnswers()
						+ " right answer/answers so far");
			}

			questionsCount++;

		}
		int correctAnswers = mlGame.getNoOfCorrectAnswers();

		float correctAnsPercentage = (correctAnswers * 100) / mlGame.getNoOfQuestionsAsked();

		if (isBetween(correctAnsPercentage, 92, 100)) {
			System.out
					.println("Congratulations, you have won a Gold medal for " + correctAnswers + " correct answers!");
		} else if (isBetween(correctAnsPercentage, 80, 91)) {
			System.out.println(
					"Congratulations, you have won a Silver medal for " + correctAnswers + " correct answers!");
		} else if (isBetween(correctAnsPercentage, 64, 79)) {
			System.out.println(
					"Congratulations, you have won a Bronze medal for " + correctAnswers + " correct answers!");
		} else if (isBetween(correctAnsPercentage, 0, 63)) {
			mlGame.printTable();
			System.out.println("Study hard and try again!");

		}
		scanner.close();

	}

	public static boolean isBetween(float x, int lower, int upper) {
		return lower <= x && x <= upper;
	}

}
