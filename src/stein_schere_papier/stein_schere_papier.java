package stein_schere_papier;

public class stein_schere_papier {

	protected enum Move {
		STEIN, SCHERE, PAPIER;

		public int compareMoves(Move otherMove) {
			// unentschieden
			if (this == otherMove)
				return 0;

			switch (this) {
			case STEIN:
				return (otherMove == SCHERE ? 1 : -1);
			case PAPIER:
				return (otherMove == STEIN ? 1 : -1);
			case SCHERE:
				return (otherMove == PAPIER ? 1 : -1);
			}
			// sollte eigentlich nie erreicht werden
			return 0;
		}

	}

	private User user = new User();
	private Computer computer = new Computer();
	private int userScore = 0;
	private int computerScore = 0;
	private int numberOfGames = 0;

	public void startGame() {
		System.out.println("STEIN, SCHERE, PAPIER!");
		Move userMove = user.getMove();
		Move computerMove = computer.getmove();
		System.out.println("\nDu hast " + userMove + " gewählt.");
		System.out.println("Der Computer wählte " + computerMove + ".\n");

		int compareMoves = userMove.compareMoves(computerMove);
		switch (compareMoves) {
		case 0: // unentschieden
			System.out.println("Unentschieden!");
			break;

		case 1: // User gewinnt
			System.out.println(userMove + "schlägt " + computerMove + "Du hast gewonnen!");
			userScore++;
			break;

		case 2: // Computer gewinnt
			System.out.println(computerMove + "schlägt " + userMove + "Der Computer hat gewonnen!");
			computerScore++;
			break;

		}
		numberOfGames++;

		// nach einer neuen Runde fragen
		if (user.playAgain()) {
			System.out.println();
			startGame();
		} else {
			printGameStats();
		}

	}

	private void printGameStats() {
		int wins = userScore;
		int losses = computerScore;
		int ties = numberOfGames - userScore - computerScore;
		double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

		// Line
		System.out.print("+");
		printDashes(68);
		System.out.println("+");

		// Print titles
		System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n", "Gewonnen", "Verloren", "Unentschieden",
				"Spiele gespielt", "Prozent gewonnen");

		// Line
		System.out.print("|");
		printDashes(10);
		System.out.print("+");
		printDashes(10);
		System.out.print("+");
		printDashes(10);
		System.out.print("+");
		printDashes(16);
		System.out.print("+");
		printDashes(18);
		System.out.println("|");

		// Print values
		System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n", wins, losses, ties, numberOfGames,
				percentageWon * 100);

		// Line
		System.out.print("+");
		printDashes(68);
		System.out.println("+");
	}

	private void printDashes(int numberOfDashes) {
		for (int i = 0; i < numberOfDashes; i++) {
			System.out.print("-");
		}
	}

	public static void main(String[] args) {
		stein_schere_papier game = new stein_schere_papier();
		game.startGame();
	}

}

// https://www.wikihow.tech/Make-a-Rock,-Paper,-Scissors-Game-in-Java
