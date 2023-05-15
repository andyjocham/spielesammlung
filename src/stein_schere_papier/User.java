package stein_schere_papier;

import java.util.Scanner;

import stein_schere_papier.stein_schere_papier.Move;

public class User {
	private Scanner inputScanner = new Scanner(System.in);

	public boolean playAgain() {
		System.out.println("Noch eine Runde? ");
		String userInput = inputScanner.nextLine();
		userInput.toUpperCase();
		return userInput.charAt(0) == 'J';
	}

	public Move getMove() {
		// frag nach der Wahl des Users
		System.out.println("Stein, Schere oder Papier? ");

		// Wahl einlesen
		String userInput = inputScanner.nextLine();
		userInput = userInput.toUpperCase();
		if (userInput == "STEIN" || userInput == "SCHERE" || userInput == "PAPIER") {
			switch (userInput) {
			case "STEIN":
				return Move.STEIN;
			case "SCHERE":
				return Move.SCHERE;
			case "PAPIER":
				return Move.PAPIER;
			}
		}

		return getMove();
	}

}
