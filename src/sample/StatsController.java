package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * The StatsController class is responsible for updating and handling user events within Stats.fxml.
 *
 * @author Adam Dressel - The StatsController class
 */
public class StatsController {

  /**
   * Switches the scene to leaderboard.fxml when the user presses the Leaderboards button.
   */
  @FXML
  public void openLeaderboard() {
    Main.loadNewView("leaderboard.fxml");
  }

  /**
   * Switches the scene to searchProf.fxml when the user presses the Search Profile button.
   */
  @FXML
  public void searchProfile() {
    Main.loadNewView("searchProf.fxml");
  }

  /**
   * Switches the scene to myProfile.fxml when the user presses the My Profile button.
   */
  @FXML
  public void myProfile() {
    Main.loadNewView("myProfile.fxml");
  }

  /**
   * Switches the scene to main-menu.fxml when the user presses the Back button.
   */
  @FXML
  public void back() {
    Main.loadNewView("main-menu.fxml");
  }
}
