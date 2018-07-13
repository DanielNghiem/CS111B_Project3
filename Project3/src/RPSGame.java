/*
 * Daniel Nghiem (W99272040)
 * CS111B
 * Project 3:  Rock, Paper, Scissors
 * 
 */

import java.util.Random;

public class RPSGame {

	// Instance data
	
	private enum MoveType {
		ROCK, PAPER, SCISSORS;
		
		public static MoveType getRandomMove() {
			Random generator = new Random();
			return values()[generator.nextInt(values().length)];
		}
		
	}
	
	private enum MatchOutcome {
		USER_WINS, COMPUTER_WINS, TIE
	}
	
	private int cWins; 
	private int uWins;
	private int ties;
	
	// Constructor
	
	public RPSGame() {
		cWins = 0;
		uWins = 0;
		ties = 0;
	}

	// Getters and Setters
	
	public int getCWins() {
		return cWins;
	}
	
	public int getUWins() {
		return uWins;
	}
	
	public int getTies() {
		return ties;
	}
	
	
	public MoveType generateComputerPlay() {
		return MoveType.getRandomMove();
	}


	public MatchOutcome findWinner(MoveType userMove, MoveType computerMove) {
		// Determine the winner using the two moves and update the win count.
		// Then, return the outcome (win/lose/tie).	
		
		return MatchOutcome.COMPUTER_WINS;
	}

}
