package cen3031team6.Statistics;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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

    lbChoiceBox.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue,
              String newValue) {
            if (newValue.equals("Overall Leaderboard")) {
              getOverallLeaderboard();
            }
          }
        });

  }

  private void getOverallLeaderboard() {
//    try {
//      String sql =
//          "SELECT * FROM " + ONEVONE_STATS_TABLE_NAME;
//
//
//    } catch (SQLException e) {
//
//    }
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
