package cen3031team6.ScoreEntry;

import cen3031team6.Login.OneVOneLoginController;
import cen3031team6.Main;
import cen3031team6.Utils.DbUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.h2.mvstore.DataUtils;

import java.sql.*;

/**
 * The ScoreEntryController class populates the score-entry.fxml view and listens for user events on
 * this view.
 *
 * @author Austin Nolz, Oscar Garcia - The ScoreEntryController checks if each user enters a valid
 * score, allows each user to verify the score of their opponent, and stores the results of the
 * match when both users verify score of the other.
 */
public class ScoreEntryController {

  //Store Score data to database.
  private String playerOne = OneVOneLoginController.matchStats.getUserNameOne();
  private String playerTwo = OneVOneLoginController.matchStats.getUserNameTwo();

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

  private boolean user1ScoreVerified = false;

  private boolean user2ScoreVerified = false;

  private OneVOneLoginController oneVOneStats = new OneVOneLoginController();

  /**
   * Calls the method loadMainMenu() within main to reassign the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenuFromScore() {
    Main.loadMainMenu();
  }

  public void initialize() {
    // setText() of labels to usernames of user1 and user2
    user1Label.setText(playerOne);
    user2Label.setText(playerTwo);


  }

  /**
   * Calls updateEnteredScore with the entered score from User 1, and if the input is a number
   * between 0 and 11 then the user1Score label is set to the submitted score. The returnMsg1 label
   * is also passed as a parameter.
   */
  @FXML
  public void updateEnteredScore1() {

    updateEnteredScore(enteredScore1, user1Score, returnMsg1);
  }

  /**
   * Calls updateEnteredScore with the entered score from User 2, and if the input is a number
   * between 0 and 11 then the user2Score label is set to the submitted score. The returnMsg2 label
   * is also passed as a parameter.
   */
  @FXML
  public void updateEnteredScore2() {

    updateEnteredScore(enteredScore2, user2Score, returnMsg2);
  }


  /**
   * The updateEnteredScore method checks whether the entered score is valid, and sets the userScore
   * label if it is valid.
   *
   * @param enteredScore - score entered by the user in the TextField
   * @param userScore - label which is set if the entered score is valid
   * @param returnMsg - Label informing the user why their input is incorrect.
   */
  private void updateEnteredScore(TextField enteredScore, Label userScore, Label returnMsg) {
    try {

      int score = Integer.parseInt(enteredScore.getText());

      if (score >= 0 && score <= 11) {
        userScore.setText(Integer.toString(score));
        returnMsg.setVisible(false);
      } else {
        returnMsg.setVisible(true);
        returnMsg.setText("Please enter a score between 0 and 11.");
      }

    } catch (NumberFormatException ex) {
      returnMsg.setVisible(true);
      returnMsg.setText("Invalid score. Please enter a number 0-11.");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Sets a boolean to show that user2 has verified the score of user1 and calls verifyBothScores()
   * to check if both user scores are verified.
   */
  @FXML
  public void verifyUser1Score() {
    user1ScoreVerified = true;
    returnMsg2.setText("Opponent score has been verified.");
    returnMsg2.setVisible(true);
    if (user2ScoreVerified) submitScores();
  }

  /**
   * Sets a boolean to show that user1 has verified the score of user2 and calls verifyBothScores()
   * to check if both user scores are verified.
   */
  @FXML
  public void verifyUser2Score() {
    user2ScoreVerified = true;
    returnMsg1.setText("Opponent score has been verified.");
    returnMsg1.setVisible(true);
    if (user1ScoreVerified) submitScores();
  }

  /**
   * Checks if both users have verified the score of their opponent.
   */
  private void submitScores() {

    try {

      // gets player one's name and id number.

      System.out.println(playerOne);
      String sql = "SELECT ID FROM USER WHERE NAME = '" + playerOne + "'";
      System.out.println("sql statment Works");
      ResultSet rs = DbUtils.getDb().getStmt().executeQuery(sql);
      rs.next();
      int playOneId = rs.getInt(DbUtils.USER_ID);
      rs.close();

      // gets player two's name and id number.

      String sqlPlayerTwo = "SELECT ID FROM USER WHERE NAME = '" + playerTwo + "'";
      ResultSet rs2 = DbUtils.getDb().getStmt().executeQuery(sqlPlayerTwo);
      rs2.next();
      int playTwoId = rs2.getInt(DbUtils.USER_ID);
      rs2.close();

      // now add to the ONEVONE_STATS table.

      String sqlInsert =
              "INSERT INTO "
                      + "ONEVONE_STATS"
                      + "("
                      + "PLAYERONE"
                      + ", "
                      + "PLAYERTWO"
                      + ", "
                      + "PLAYERONE_SCORE"
                      + ", "
                      + "PLAYERTWO_SCORE"
                      + ", "
                      + "DATE"
                      + ")"
                      + " VALUES(?, ?, ?, ?, ?)";

      PreparedStatement preparedStatement = DbUtils.getDb().getConn().prepareStatement(sqlInsert);

      preparedStatement.setInt(1, playOneId);
      preparedStatement.setInt(2, playTwoId);
      preparedStatement.setInt(3, Integer.parseInt(enteredScore1.getText()));
      preparedStatement.setInt(4, Integer.parseInt(enteredScore2.getText()));
      preparedStatement.setLong(5, System.currentTimeMillis());
      preparedStatement.executeUpdate();

    } catch(SQLException e) {
      e.printStackTrace();
    }

    Main.loadMainMenu();

  }

}
