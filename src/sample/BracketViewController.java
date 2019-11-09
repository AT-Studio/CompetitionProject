package sample;

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
  private Label user1Label;

  @FXML
  private Label user2Label;

  public void initialize() {
    //Tournament bracket positions are filled randomly

    //Populate the bracket username labels

    // setText() on user1Label and user2Label to next two users, until all matches are complete
  }

  /**
   * The method returnToMenu() switches the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * Tournament login for next randomly selected user.
   */
  @FXML
  public void loginUser1() {

  }

  /**
   * Tournament login for next randomly selected user2
   */
  @FXML
  public void loginUser2() {

  }
}
