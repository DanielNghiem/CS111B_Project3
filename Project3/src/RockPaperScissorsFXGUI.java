import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class RockPaperScissorsFXGUI extends Application {

	private ImageView computerMoveImageView, userMoveImageView;
	private Image rockImage, paperImage, scissorsImage;
	private Text matchOutcomeText, cWinsText, uWinsText, tieText;
	private Text betText;
	private Button rockButton, paperButton, scissorsButton;
	private HBox labelBox;

	private RPS game;

	public void start(Stage primaryStage) {

		int betAmount = getBetAmount(); // only if completing the extra credit!

		game = new RPS(betAmount);
		
		/* the image and labels for the computer and user move */
		rockImage = new Image("rock.jpg");
		paperImage = new Image("paper.jpg");
		scissorsImage = new Image("scissors.jpg");

		computerMoveImageView = new ImageView(rockImage);
		computerMoveImageView.setVisible(false); // used to make the initial screen layout appear the same as when the game starts
		userMoveImageView = new ImageView(rockImage);
		userMoveImageView.setVisible(false); 
		HBox imageBox = new HBox(computerMoveImageView, userMoveImageView);
		imageBox.setAlignment(Pos.CENTER);
		imageBox.setSpacing(20);

		Text computerLabel = new Text("Computer's Move");
		computerLabel.setFont(Font.font("Helvetica", 14));
		Text yourLabel = new Text("Your Move");
		yourLabel.setFont(Font.font("Helvetica", 14));
		labelBox = new HBox(computerLabel, yourLabel);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.setSpacing(30);
		labelBox.setVisible(false);

		/* the results of each match */
		matchOutcomeText = new Text();
		matchOutcomeText.setFill(Color.GREEN);
		matchOutcomeText.setFont(Font.font("Helvetica", 20));

		/* the buttons for the user's play */
		rockButton = new Button("Play Rock");
		rockButton.setOnAction(this::handleUserPlay);
		paperButton = new Button("Play Paper");
		paperButton.setOnAction(this::handleUserPlay);
		scissorsButton = new Button("Play Scissors");
		scissorsButton.setOnAction(this::handleUserPlay);
		HBox buttonBox = new HBox(rockButton, paperButton, scissorsButton);
		buttonBox.setSpacing(10);
		buttonBox.setAlignment(Pos.CENTER);
		
		/* the game statistics */
		cWinsText = new Text("Computer Wins: " + game.getCWins());
		cWinsText.setFont(Font.font("Helvetica", 16));
		cWinsText.setFill(Color.BLUE);
		uWinsText = new Text("User Wins: " + game.getUWins());
		uWinsText.setFont(Font.font("Helvetica", 16));
		uWinsText.setFill(Color.BLUE);
		tieText = new Text("Ties: " + game.getTies());
		tieText.setFont(Font.font("Helvetica", 16));
		tieText.setFill(Color.BLUE);
		HBox statsBox = new HBox(cWinsText, uWinsText, tieText);
		statsBox.setSpacing(10);
		statsBox.setAlignment(Pos.CENTER);
		
		VBox pane = new VBox(imageBox, labelBox, matchOutcomeText, buttonBox, statsBox);
		pane.setAlignment(Pos.CENTER);
		pane.setSpacing(20);
		pane.setStyle("-fx-background-color: white");

		Scene scene = new Scene(pane, 400, 400, Color.TRANSPARENT);
		primaryStage.setTitle("Rock, Paper, Scissors, Go!");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// only implemented this method if completing the extra credit
	private int getBetAmount() {
		
		// YOUR EXTRA CREDIT CODE HERE
		return 0;
	}

	private void handleUserPlay(ActionEvent event) {
		// to make all aspects of the display visible
		userMoveImageView.setVisible(true);
		computerMoveImageView.setVisible(true);
		labelBox.setVisible(true);
		
		// YOUR CODE HERE

	}

	public static void main(String[] args) {
		launch(args);
	}

}
