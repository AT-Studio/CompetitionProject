package sample;

import java.util.InputMismatchException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ScoreEntryController {

  @FXML
  private Label user1Label;

  @FXML
  private Label user2Label;

  @FXML
  private Label user1Score;

  @FXML
  private Label user2Score;

  @FXML
  private TextField enteredScore1;

  @FXML
  private TextField enteredScore2;

  @FXML
  private Label returnMsg1;

  @FXML
  private Label returnMsg2;

  @FXML
  public void returnToMenuFromScore(ActionEvent event) {
    Main.loadMainMenu();
  }

  public void iniitialize() {
    // setText() of labels to usernames of user1 and user2

  }

  @FXML
  public void updateEnteredScore1() {

    updateEnteredScore(enteredScore1, user1Score, returnMsg1);
  }

  @FXML
  public void updateEnteredScore2() {

    updateEnteredScore(enteredScore2, user2Score, returnMsg2);
  }

  private void updateEnteredScore(TextField enteredScore2, Label user2Score, Label returnMsg2) {
    try {
      int score2 = Integer.parseInt(enteredScore2.getText());

      if (score2 >= 0 && score2 <= 11) {
        user2Score.setText(Integer.toString(score2));
        returnMsg2.setVisible(false);
      } else {
        returnMsg2.setVisible(true);
        returnMsg2.setText("Please enter a score between 0 and 11.");
      }

    } catch (NumberFormatException ex) {
      returnMsg2.setVisible(true);
      returnMsg2.setText("Invalid score. Please enter a number 0-11.");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
