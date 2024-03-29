package cen3031team6.Statistics;

import cen3031team6.Main;
import javafx.fxml.FXML;

/**
 * The StatsController class is responsible for updating and handling user events within
 * Stats.fxml.
 *
 * @author Adam Dressel - The StatsController class
 */
public class StatsController {

  /**
   * Switches the scene to leaderboard.fxml when the user presses the Leaderboards button.
   */
  @FXML
  public void openLeaderboard() {
    Main.loadNewView("./Statistics/leaderboard.fxml");
  }

  /**
   * Switches the scene to searchProf.fxml when the user presses the Search Profile button.
   */
  @FXML
  public void searchProfile() {
    Main.loadNewView("./Statistics/searchProf.fxml");
  }

  /**
   * Switches the scene to userProfile.fxml when the user presses the My Profile button.
   */
  @FXML
  public void myProfile() {
    Main.loadNewView("./Login/single-user-login.fxml");
    Main.setPreviousFXML("./Statistics/userProfile.fxml");
  }

  /**
   * Switches the scene to main-menu.fxml when the user presses the Back button.
   */
  @FXML
  public void back() {
    Main.loadNewView("./MainMenu/main-menu.fxml");
  }
}
