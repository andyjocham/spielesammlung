package stein_schere_papier;

import java.util.Random;

import stein_schere_papier.stein_schere_papier.Move;

public class Computer {
	public Move getmove() {
		Move[] moves = Move.values();
		Random random = new Random();
		int index = random.nextInt(moves.length);

		return moves[index];
	}
}
