package stein_schere_papier;

import java.util.Scanner;

import stein_schere_papier.stein_schere_papier.Move;

public class User {
	private Scanner inputScanner = new Scanner(System.in);

	public boolean playAgain() {
		System.out.println("Noch eine Runde? (J)a (N)ein");
		String userInput = inputScanner.nextLine();
		userInput = userInput.toUpperCase();
		return userInput.charAt(0) == 'J';
	}

	public Move getMove() {
		// frag nach der Wahl des Users
		System.out.println("Deine Wahl - Stein, Schere oder Papier? ");

		// Wahl einlesen
		String userInput = inputScanner.nextLine();
		userInput = userInput.toUpperCase();
		char lastLetter = userInput.charAt(userInput.length() - 1);
		if (lastLetter == 'N' || lastLetter == 'E' || lastLetter == 'R') {
			switch (lastLetter) {
			case 'N':
				return Move.STEIN;
			case 'E':
				return Move.SCHERE;
			case 'R':
				return Move.PAPIER;
			}

		}
		// falsche Eingabe
		return getMove();

	}

}
