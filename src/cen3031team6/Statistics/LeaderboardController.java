package cen3031team6.Statistics;

import cen3031team6.Utils.DbUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import cen3031team6.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static cen3031team6.Utils.DbUtils.ONEVONE_STATS_TABLE_NAME;

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

  @FXML
  private TableView<PlayerOneVOneStat> tv_stats;

  public void initialize() {
    lbChoiceBox.getItems().add("Overall Leaderboard");
    lbChoiceBox.getItems().add("TournamentPkg Leaderboard");

    lbChoiceBox.getSelectionModel().selectedItemProperty().addListener(
        new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue,
              String newValue) {
            if (newValue.equals("Overall Leaderboard")) {
              tv_stats.setItems(getOverallLeaderboard());
            }
          }
        });

  }

  private ObservableList<PlayerOneVOneStat> getOverallLeaderboard() {
    Map<String, PlayerOneVOneStat> stats = new HashMap<>();

    try {
      String sql =
          "SELECT * FROM " + ONEVONE_STATS_TABLE_NAME;
      ResultSet set = DbUtils.getDb().getStmt().executeQuery(sql);

      while (set.next()) {
        String playerOneName = set.getString(DbUtils.ONEVONE_STATS_PLAYER_ONE);
        String playerTwoName = set.getString(DbUtils.ONEVONE_STATS_PLAYER_TWO);
        int playerOneScore = set.getInt(DbUtils.ONEVONE_STATS_PLAYER_ONE_SCORE);
        int playerTwoScore = set.getInt(DbUtils.ONEVONE_STATS_PLAYER_TWO_SCORE);

        PlayerOneVOneStat playerOneStats = stats.get(playerOneName);
        PlayerOneVOneStat playerTwoStats = stats.get(playerTwoName);
        if (playerOneStats == null) playerOneStats = new PlayerOneVOneStat(playerOneName);
        if (playerTwoStats == null) playerTwoStats = new PlayerOneVOneStat(playerTwoName);
        if (playerOneScore > playerTwoScore) {
          playerOneStats.incrementWins();
          playerTwoStats.incrementLosses();
        } else if (playerTwoScore > playerOneScore) {
          playerOneStats.incrementLosses();
          playerTwoStats.incrementWins();
        } else {
          playerOneStats.incrementTies();
          playerTwoStats.incrementTies();
        }
        stats.put(playerOneName, playerOneStats);
        stats.put(playerTwoName, playerTwoStats);
      }

    } catch (SQLException e) {

    }

    ObservableList<PlayerOneVOneStat> obsStats = FXCollections.observableArrayList(stats.values());
    Collections.sort(obsStats, new Comparator<PlayerOneVOneStat>() {
      @Override
      public int compare(PlayerOneVOneStat o1, PlayerOneVOneStat o2) {
        return o2.getScore() - o1.getScore();
      }
    });

    return obsStats;
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
