package cen3031team6.Statistics;

import cen3031team6.DataModels.MatchStat;
import cen3031team6.DataModels.User;
import cen3031team6.Main;
import cen3031team6.Utils.DbUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * UserProfileController is a class which listens for user events in the userProfile.fxml view.
 *
 * @author Adam Dressel, Austin Nolz - The UserProfileController is the controller class for
 * userProfile.fxml, which populates the matchTable, tournTable, and user statistics. This class
 * also listens for the user selecting from the tournCombo to choose a tournament and view the
 * respective statistics.
 */
public class UserProfileController {

  @FXML
  private Label usernameLabel;

  @FXML
  private TableView<MatchStat> matchTable = new TableView<>();

  @FXML
  private TableView<MatchStat> tournTable = new TableView();

  @FXML
  private Label totalPointsLabel;

  @FXML
  private Label totalWinsLabel;

  @FXML
  private Label totalLossesLabel;

  private ObservableList<MatchStat> matchStats;

  private ObservableList<MatchStat> tournMatchStats;

  private User currentUser;

  private int userTotalWins = 0;

  private int userTotalLosses = 0;

  private int userTotalPoints = 0;

  /**
   * The initialize method sets the currentUser from the selected user in SearchProf.fxml, then
   * sets the username Label, calls two methods to query statistics for 1v1 and tournament matches.
   * Then, calcTotalPoints is called for each 1v1 matchStats and tournMatchStats. Total wins, total
   * losses and total points are then displayed in the view.
   */
  public void initialize() {

    //Populate tables with user statistics
    this.currentUser = SearchProfController.getSelectedUser();

    usernameLabel.setText(currentUser.getUsername());

    queryOneVOneStats();
    queryTournMatchStats();

    calcTotalPoints(matchStats);

    calcTotalPoints(tournMatchStats);

    totalWinsLabel.setText(Integer.toString(userTotalWins));
    totalLossesLabel.setText(Integer.toString(userTotalLosses));
    totalPointsLabel.setText(Integer.toString(userTotalPoints));
  }

  /**
   * The calcTotalPoints method iterates through the match results and calculates the total points
   * scored by the user in all of his or her matches.
   *
   * @param matchStats - The list of match results.
   */
  private void calcTotalPoints(ObservableList<MatchStat> matchStats) {
    for (MatchStat matchStat : matchStats) {
      char wOrL = matchStat.getWinOrLoss();

      int matchPoints = matchStat.getUserScore();
      userTotalPoints += matchPoints;

      calcTotalWinsLosses(wOrL);
    }
  }

  /**
   * The calcTotalWinsLosses method increments the variables for total wins and losses.
   *
   * @param wOrL - The character of W or L designating a win or loss for that match.
   */
  private void calcTotalWinsLosses(char wOrL) {
    switch (wOrL) {
      case 'W':
        userTotalWins++;
        break;
      case 'L':
        userTotalLosses++;
        break;
      default:
        System.out.println("Error");
        break;
    }
  }

  /**
   * The back() method switches the screen to Stats.fxml.
   */
  @FXML
  public void back() {
    Main.loadNewView("./Statistics/Stats.fxml");
  }

  /**
   * The returnToMenu() method switches the screen to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * The queryOneVOneStats method searches through the ONEVONE_STATS table for match statistics that
   * the selected user played in.
   */
  private void queryOneVOneStats() {

    String sql = "SELECT PLAYERTWO, PLAYERONE_SCORE, PLAYERTWO_SCORE FROM "
        + DbUtils.ONEVONE_STATS_TABLE_NAME + " WHERE "
        + DbUtils.ONEVONE_STATS_PLAYER_ONE + "= \'" + currentUser.getUsername() + "\'";

    try {

      ResultSet set = DbUtils.getDb().getStmt().executeQuery(sql);

      matchStats = FXCollections.observableArrayList();
      addMatchesToTable(set);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    sql = "SELECT PLAYERONE, PLAYERONE_SCORE, PLAYERTWO_SCORE FROM "
        + DbUtils.ONEVONE_STATS_TABLE_NAME + " WHERE "
        + DbUtils.ONEVONE_STATS_PLAYER_TWO + "= \'" + currentUser.getUsername() + "\'";

    try {

      ResultSet rs = DbUtils.getDb().getStmt().executeQuery(sql);

      addMatchesToTable(rs);

      if (matchStats.isEmpty()) {
        matchStats.add(new MatchStat());
      }
      matchTable.setItems(matchStats);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * The queryTournMatchStats method searches through the TOURN_STAT table for match statistics that
   * the selected user played in.
   */
  private void queryTournMatchStats() {

    String sql = "SELECT PLAYERTWO, PLAYERONE_SCORE, PLAYERTWO_SCORE FROM "
        + DbUtils.TOURN_STAT_TABLE_NAME + " WHERE "
        + DbUtils.TOURN_STAT_PLAYER_ONE_NAME + "= \'" + currentUser.getUsername() + "\'";

    try {

      ResultSet set = DbUtils.getDb().getStmt().executeQuery(sql);

      tournMatchStats = FXCollections.observableArrayList();
      addMatchesToTournTable(set);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    sql = "SELECT PLAYERONE, PLAYERONE_SCORE, PLAYERTWO_SCORE FROM "
        + DbUtils.TOURN_STAT_TABLE_NAME + " WHERE "
        + DbUtils.TOURN_STAT_PLAYER_ONE_NAME + "= \'" + currentUser.getUsername() + "\'";

    try {

      ResultSet rs = DbUtils.getDb().getStmt().executeQuery(sql);

      addMatchesToTournTable(rs);

      if (tournMatchStats.isEmpty()) {
        tournMatchStats.add(new MatchStat());
      }
      tournTable.setItems(tournMatchStats);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * The addMatchesToTable method calls setTableView for the 1v1 matchStats.
   *
   * @param rs - the resultSet object to be processed and added to the matchTable.
   * @throws SQLException - Handles SQL Exceptions
   */
  private void addMatchesToTable(ResultSet rs) throws SQLException {
    setTableView(rs, matchStats);
  }

  /**
   * The addMatchesToTournTable method calls setTableView for the tournMatchStats.
   *
   * @param rs - the resultSet object to be processed and added to the matchTable.
   * @throws SQLException - Handles SQL Exceptions
   */
  private void addMatchesToTournTable(ResultSet rs) throws SQLException {
    setTableView(rs, tournMatchStats);
  }

  /**
   *
   * @param rs - the resultSet object to be processed and added to the matchTable.
   * @param matchStats - ObservableList of type MatchStat with 1v1 or tournament stats.
   * @throws SQLException
   */
  private void setTableView(ResultSet rs, ObservableList<MatchStat> matchStats)
      throws SQLException {
    while (rs.next()) {

      String opponentName = rs.getString(1);
      int userScore = rs.getInt(2);
      int opponentScore = rs.getInt(3);

      matchStats.add(new MatchStat(opponentName, userScore, opponentScore));

    }

    rs.close();
  }
}
