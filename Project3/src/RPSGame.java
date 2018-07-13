/*
 * Daniel Nghiem (W99272040)
 * CS111B
 * Project 3:  Rock, Paper, Scissors
 * 
 */

import java.util.Random;

public class RPSGame {

	// Instance data
	
	public enum MoveType {
		ROCK, PAPER, SCISSORS;
		
		public static MoveType getRandomMove() {
			Random generator = new Random();
			return values()[generator.nextInt(values().length)];
		}
		
	}
	
	public enum MatchOutcome {
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
		// Then, return the outcome.
		
		MatchOutcome outcome = MatchOutcome.TIE;	// Local variables must be initialized
		
		if (userMove == MoveType.ROCK) {
			if (computerMove == MoveType.ROCK) {
				outcome = MatchOutcome.TIE;
			} else if (computerMove == MoveType.PAPER) {
				outcome = MatchOutcome.COMPUTER_WINS;
			} else {		
				outcome = MatchOutcome.USER_WINS;
			}
		} else if (userMove == MoveType.PAPER) {
			if (computerMove == MoveType.ROCK) {
				outcome = MatchOutcome.USER_WINS;
			} else if (computerMove == MoveType.PAPER) {
				outcome = MatchOutcome.TIE;
			} else {		
				outcome = MatchOutcome.COMPUTER_WINS;
			}
		} else {		// userMove == MoveType.SCISSORS
			if (computerMove == MoveType.ROCK) {
				outcome = MatchOutcome.COMPUTER_WINS;
			} else if (computerMove == MoveType.PAPER) {
				outcome = MatchOutcome.USER_WINS;
			} else {		
				outcome = MatchOutcome.USER_WINS;
			}
		}
		
		if (outcome == MatchOutcome.USER_WINS) uWins += 1;
		else if (outcome == MatchOutcome.COMPUTER_WINS) cWins += 1;
		else ties += 1;
		
		return outcome;
	}

	public String toString() {
		return "";
	}

}
