import javafx.scene.control.*;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Optional;

public class Helper {
    public static void initMatchOutcomeHashMap(HashMap<RPSGame.MatchOutcome, String> matchOutcomeStrings) {
        matchOutcomeStrings.put(RPSGame.MatchOutcome.USER_WINS, "You win!");
        matchOutcomeStrings.put(RPSGame.MatchOutcome.COMPUTER_WINS, "You Lose!");
        matchOutcomeStrings.put(RPSGame.MatchOutcome.TIE, "It's a tie!");
    }

    public static void initMoveImagesHashMap(HashMap<RPSGame.MoveType, Image> moveImages) {
        moveImages.put(RPSGame.MoveType.ROCK, new Image("./rock.jpg"));
        moveImages.put(RPSGame.MoveType.PAPER, new Image("./paper.jpg"));
        moveImages.put(RPSGame.MoveType.SCISSORS, new Image("./scissors.jpg"));
    }

    public static Integer getBetAmount() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Wanna bet");
        alert.setContentText("Would you like to bet?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            TextInputDialog dialog = new TextInputDialog("12");
            dialog.setContentText("Enter Amount:");

            Optional<String> inputResult = dialog.showAndWait();
            if (inputResult.isPresent()) {
                try {
                    return Integer.parseInt(inputResult.get());
                } catch (Exception ex) {
                }
            }

        }

        return null;
    }

    public class ButtonTexts {
        public static final String ROCK = "Play Rock";
        public static final String SCISSORS = "Play Scissors";
        public static final String PAPER = "Play Paper";

    }
}


