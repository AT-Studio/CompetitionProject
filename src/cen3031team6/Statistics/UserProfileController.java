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

  private ObservableList<MatchStat> matchStats;

  private ObservableList<MatchStat> tournMatchStats;

  @FXML
  private TableView tournTable = new TableView();

  private User currentUser;

  public void initialize() {

    //Populate tables with user statistics
    this.currentUser = SearchProfController.getSelectedUser();

    usernameLabel.setText(currentUser.getUsername());

    queryOneVOneStats();
    queryTournMatchStats();
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
   * The queryOneVOneStats method searches through the ONEVONE_STATS table for match statistics
   * that the selected user played in.
   */
  public void queryOneVOneStats() {

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

      if(matchStats.isEmpty()){
        matchStats.add(new MatchStat());
      }
      matchTable.setItems(matchStats);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void queryTournMatchStats() {

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

      if(tournMatchStats.isEmpty()){
        tournMatchStats.add(new MatchStat());
      }
      tournTable.setItems(tournMatchStats);

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  /**
   * The addMatchesToTable method
   *
   * @param rs - the resultSet object to be processed and added to the matchTable.
   * @throws SQLException - Handles SQL Exceptions
   */
  private void addMatchesToTable(ResultSet rs) throws SQLException {
    setTableView(rs, matchStats);
  }

  private void addMatchesToTournTable(ResultSet rs) throws SQLException {
    setTableView(rs, tournMatchStats);
  }

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
