
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

import java.util.HashMap;
import java.util.Optional;

public class RockPaperScissorsFXGUI extends Application {

    private ImageView computerMoveImageView, userMoveImageView;
    private Text matchOutcomeText, cWinsText, uWinsText, tieText;
    private Text betText;
    private Button rockButton, paperButton, scissorsButton;
    private HBox labelBox;

    private RPSGame game;
    private HashMap<RPSGame.MatchOutcome, String> matchOutcomeStrings = new HashMap<>();
    private HashMap<RPSGame.MoveType, Image> moveImages = new HashMap<>();


    public void start(Stage primaryStage) {


        Helper.initMatchOutcomeHashMap(this.matchOutcomeStrings);
        Helper.initMoveImagesHashMap(this.moveImages);
        game = new RPSGame(Helper.getBetAmount());

        computerMoveImageView = new ImageView();
        userMoveImageView = new ImageView();

        computerMoveImageView.setVisible(false); // used to make the initial screen layout appear the same as when the game starts
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
        rockButton = new Button(Helper.ButtonTexts.ROCK);
        rockButton.setOnAction(this::handleUserPlay);
        paperButton = new Button(Helper.ButtonTexts.PAPER);
        paperButton.setOnAction(this::handleUserPlay);
        scissorsButton = new Button(Helper.ButtonTexts.SCISSORS);
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
        betText = new Text();
        betText.setFont(Font.font("Helvetica", 16));
        betText.setFill(Color.BROWN);

        betText.setVisible(this.game.isBetting());
        betText.setText("Balance :0");

        HBox statsBox = new HBox(cWinsText, uWinsText, tieText);
        HBox betBox = new HBox(betText);
        statsBox.setSpacing(10);
        statsBox.setAlignment(Pos.CENTER);
        betBox.setAlignment(Pos.CENTER);

        VBox pane = new VBox(imageBox, labelBox, matchOutcomeText, buttonBox, statsBox, betBox);
        pane.setAlignment(Pos.CENTER);
        pane.setSpacing(20);
        pane.setStyle("-fx-background-color: white");

        Scene scene = new Scene(pane, 400, 400, Color.TRANSPARENT);
        primaryStage.setTitle("Rock, Paper, Scissors, Go!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private void handleUserPlay(ActionEvent event) {
        // to make all aspects of the display visible
        userMoveImageView.setVisible(true);
        computerMoveImageView.setVisible(true);
        labelBox.setVisible(true);

        Button playButton = ((Button) event.getSource());


        RPSGame.MoveType playerMove = getUserMove(playButton);
        RPSGame.MoveType computerMove = getComputerMove();

        RPSGame.MatchOutcome matchOutcome = this.game.findWinner(playerMove, computerMove);

        updateStatUi(matchOutcome);
    }

    public RPSGame.MoveType getUserMove(Button playButton) {
        RPSGame.MoveType playerMove = playButton.getText().equals(Helper.ButtonTexts.PAPER) ? RPSGame.MoveType.PAPER : playButton.getText().equals(Helper.ButtonTexts.SCISSORS) ? RPSGame.MoveType.SCISSORS : RPSGame.MoveType.ROCK;
        userMoveImageView.setImage(moveImages.get(playerMove));
        return playerMove;
    }

    public RPSGame.MoveType getComputerMove() {
        RPSGame.MoveType computerMove = game.generateComputerPlay();
        computerMoveImageView.setImage(moveImages.get(computerMove));
        return computerMove;
    }

    public void updateStatUi(RPSGame.MatchOutcome matchOutcome) {
        matchOutcomeText.setText(matchOutcomeStrings.get(matchOutcome));
        cWinsText.setText(String.format("Computer Wins: %d", game.getCWins()));
        uWinsText.setText(String.format("User Wins: %d", game.getUWins()));
        tieText.setText(String.format("Ties: %d", game.getTies()));
        if (game.isBetting()) {
            betText.setText(String.format("Balance : %d", this.game.getUserBalance()));
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
