package cen3031team6.TournamentPkg;

import cen3031team6.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The BracketViewController updates the view and listens for user events within bracket-view.fxml.
 *
 * @author Austin Nolz The BracketViewController is the controller class for the bracket-view.fxml
 * view. This view shows the tournament bracket for a four player competition. This class updates
 * the username labels and the scores of each user after each user signs in and logs their scores.
 */
public class BracketViewController {

  @FXML
  private Label uName1;

  @FXML
  private Label uName2;

  @FXML
  private Label uName3;

  @FXML
  private Label uName4;

  @FXML
  private Label score1;

  @FXML
  private Label score2;

  @FXML
  private Label score3;

  @FXML
  private Label score4;

  @FXML
  private Label semiName1;

  @FXML
  private Label semiName2;

  @FXML
  private Label semiScore1;

  @FXML
  private Label semiScore2;

  @FXML
  private Label winnerName;

  @FXML
  private Label winnerScore;

  public void initialize() {
    //TournamentPkg bracket positions are filled randomly

    //Populate the bracket username labels

    // setText() on user1Label and user2Label to next two users, until all matches are complete

    uName1.setText(TournDetailPageController.getUserList().get(0).getUsername());
    uName2.setText(TournDetailPageController.getUserList().get(1).getUsername());
    uName3.setText(TournDetailPageController.getUserList().get(2).getUsername());
    uName4.setText(TournDetailPageController.getUserList().get(3).getUsername());

    score1.setText("");
    score2.setText("");
    score3.setText("");
    score4.setText("");
  }

  /**
   * The method returnToMenu() switches the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * TournamentPkg login for next randomly selected user.
   */
  @FXML
  public void loginUser1() {

  }

  /**
   * TournamentPkg login for next randomly selected user2
   */
  @FXML
  public void loginUser2() {

  }
}
