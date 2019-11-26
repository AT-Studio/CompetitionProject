package cen3031team6.TournamentPkg;

import cen3031team6.Main;
import cen3031team6.DataModels.Tournament;

import java.sql.*;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 * The TournSelectionController class updates and listens for user events within the
 * user-tourn-selection.fxml view.
 *
 * @author Austin Nolz - The TournSelectionController class
 */
public class TournSelectionController {

  @FXML
  private TableView<Tournament> tournTable = new TableView();
  private ObservableList<Tournament> tournaments;

  static Connection conn;

  static Statement stmt;

  public void initialize() {

    initializeDB();

//    tournaments = FXCollections.observableArrayList();
//
//    tournaments.add(new Tournament("FGCU SEC 2019",
//        new Date(), "1:00 PM"));
    tournTable.setItems(getTournaments());

  }

  public static void initializeDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/pongdb";

    final String USER = "";
    final String PASS = "";

    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Switches the view to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }


  private ObservableList<Tournament> getTournaments() {

    ObservableList<Tournament> tournaments = FXCollections.observableArrayList();

    try {
      String sql = "SELECT * FROM TOURNAMENT";
      ResultSet set = stmt.executeQuery(sql);

      while (set.next()) {
        String name = set.getString("NAME");
        long startDate = set.getLong("START_DATE");
        Date date = new Date(startDate);
        String[] dateSplit = date.toString().split(" ");
        tournaments.add(new Tournament(name, dateSplit[1] + " " + dateSplit[2],
                dateSplit[3]));
      }

      set.close();

    } catch (SQLException e) {

    }

    return tournaments;
  }

  private void addTournament() {

  }

  /**
   * The user selects a tournament row within the tournTable and tourn-detail-page.fxml is then
   * loaded and the tournament information is displayed in labels in the view.
   */
  @FXML
  public void loadTournDetails() {

    /*
     * Loads the tourn-detail-page.fxml and populates the info labels with the selected TournamentPkg
     * within the tournTable TableView.
     */

    Main.loadNewView("./TournamentPkg/tourn-detail-page.fxml");
  }
}
