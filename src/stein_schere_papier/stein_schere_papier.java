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
		System.out.println("***** SCHNICK, SCHNACK, SCHNUCK! *****");
		Move userMove = user.getMove();
		Move computerMove = computer.getmove();
		System.out.println("\nDu nimmst " + userMove + ".");
		System.out.println("Der Computer nimmt " + computerMove + ".\n");

		int compareMoves = userMove.compareMoves(computerMove);
		switch (compareMoves) {
		case 0: // unentschieden
			System.out.println("Unentschieden!\n");
			break;

		case 1: // User gewinnt
			System.out.println(userMove + " schlaegt " + computerMove + ". Du hast gewonnen!\n");
			userScore++;
			break;

		case -1: // Computer gewinnt
			System.out.println(computerMove + " schlaegt " + userMove + ". Der Computer hat gewonnen!\n");
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

		System.out.println("\n" + numberOfGames + " Runde(n) gespielt.\n");
		System.out.println("Du hast " + userScore + "x gewonnen und " + computerScore + "x verloren!");
		System.out.println(+ties + "x mal war es unentschieden, das entspricht einer Gewinnquote von "
				+ percentageWon * 100 + "%");
	}

	public static void main(String[] args) {
		stein_schere_papier game = new stein_schere_papier();
		game.startGame();
	}

}

// https://www.wikihow.tech/Make-a-Rock,-Paper,-Scissors-Game-in-Java
