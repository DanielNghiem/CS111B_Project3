
public class Tests {

	public static void main(String[] args) {
		RPSGame game = new RPSGame();
		
		System.out.println(game.getCWins());
		
		// Test random computer move
		for (int i=0; i<10; i++) {
			System.out.println(game.generateComputerPlay());
		}
			
		System.out.println(game.findWinner(RPSGame.MoveType.PAPER, RPSGame.MoveType.SCISSORS));
		System.out.println(game.findWinner(RPSGame.MoveType.ROCK, RPSGame.MoveType.SCISSORS));	
		System.out.println(game.findWinner(RPSGame.MoveType.PAPER, RPSGame.MoveType.PAPER));
	}

}
