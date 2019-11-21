package cen3031team6.Statistics;

import cen3031team6.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 * The LeaderboardController updates the view and listens for user events within leaderboard.fxml.
 *
 * @author Adam Dressel - The LeaderboardController is the controller class for the leaderboard.fxml
 * view. This view allows the user to select the TournamentPkg Leaderboard or the Overall leaderboard.
 * This class updates the table view with the respective leaderboard selected by the user.
 */
public class LeaderboardController {

  @FXML
  private ChoiceBox<String> lbChoiceBox;

  public void initialize() {
    lbChoiceBox.getItems().add("Overall Leaderboard");
    lbChoiceBox.getItems().add("TournamentPkg Leaderboard");

  }

  /**
   * This method switches the scene back to the Stats.fxml view.
   */
  public void back() {
    Main.loadNewView("./Statistics/Stats.fxml");
  }

  /**
   * This method switches the scene back to the main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

}
