package cen3031team6.Admin;

import cen3031team6.Main;
import cen3031team6.DataModels.Tournament;
import cen3031team6.Utils.DbUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

/**
 * The AdminTournManagerController class is the controller for the admin-tourn-manager.fxml view.
 *
 * @author Austin Nolz - The AdminTournManagerController populates the tournTable, which shows all
 * tournaments in the database. An administrator can press the create button to make a new
 * tournament, or press the delete button to remove a tournament from the database and tournTable.
 */
public class AdminTournManagerController {

  @FXML
  private TextField tournamentName;

  @FXML
  private DatePicker startDate;

  @FXML
  private ChoiceBox<String> startTimeBox;

  @FXML
  private TableView<Tournament> tournTable;

  @FXML
  private TableColumn<?, ?> tournNameCol;

  @FXML
  private TableColumn<?, ?> tournStartDateCol;

  @FXML
  private TableColumn<?, ?> tournStartTimeCol;

  private ObservableList<Tournament> tournaments;

  @FXML
  private Label returnMsg;

  public void initialize() {
    // Sets the AM times for the choice box.
    for (int i = 1; i < 13; i++) {
      startTimeBox.getItems().add(i + ":00 AM");
    }

    // Sets the PM times for the choice box.
    for (int i = 1; i < 13; i++) {
      startTimeBox.getItems().add(i + ":00 PM");
    }

    startDate.setEditable(false);

    getTournamentTableReady();
  }

  /**
   * Switches the view to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * This action gets teh String values from the tournament Name textfield, start date text field
   * and the start time text field, and then inserts them into the Tournament Table in our data
   * base. While also displaying the tournament that was just created into our table view.
   *
   * @param actionEvent This happens when the create tournament button is pressed.
   */
  public void addingTournamentInDB(ActionEvent actionEvent) {
    if (tournamentName.getText() != null && startDate.getValue() != null
        && startTimeBox.getValue() != null) {

      String tournName = tournamentName.getText();
      String tournDate = startDate.getValue().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
      String start_Time = startTimeBox.getValue();

      try {
        String sqlTournament = "INSERT INTO TOURNAMENT (NAME, START_DATE, START_TIME) VALUES " +
            "(?,?,?)";
        PreparedStatement preparedStatementTournament = DbUtils.getDb().getConn()
            .prepareStatement(sqlTournament);
        preparedStatementTournament.setString(1, tournName);
        preparedStatementTournament.setString(2, tournDate);
        preparedStatementTournament.setString(3, start_Time);
        preparedStatementTournament.executeUpdate();
        System.out.println("Pressed the button.");
      } catch (SQLException e) {
        e.printStackTrace();
      }
      tournTable.setItems(readFromTournDB());
    } else {
      returnMsg.setText("Enter a name, date, and time.");
      returnMsg.setVisible(true);
    }
  }

  public void deleteTournamentInDb(ActionEvent actionEvent) {
    int idx = tournTable.getSelectionModel().getSelectedIndex();

    Tournament selectedTourn = tournTable.getSelectionModel().getSelectedItem();
    if (selectedTourn == null) {
      returnMsg.setText("Select a tournament.");
      returnMsg.setVisible(true);
    } else {

      if (idx >= 0) {
        try {
          String sql = "DELETE FROM " + DbUtils.TOURNAMENT_TABLE_NAME + " WHERE "
              + DbUtils.TOURNAMENT_ID + " = " + tournaments.get(idx).getId();
          DbUtils.getDb().getStmt().execute(sql);
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
        tournTable.setItems(readFromTournDB());
      }
    }
  }

  /**
   * This method prepares our table view to accept Tournament objects with the columns(fields) to be
   * tournament name, tournament start date and time.
   */
  public void getTournamentTableReady() {
    tournNameCol.setCellValueFactory(new PropertyValueFactory("TournamentName"));
    tournStartDateCol.setCellValueFactory(new PropertyValueFactory("startDate"));
    tournStartTimeCol.setCellValueFactory(new PropertyValueFactory("startTime"));

    tournTable.setItems(readFromTournDB());
  }

  /**
   * This method will read from the Tournament table in our database and will get each existing
   * entry and insert it into our tableview.
   *
   * @return returns an ObservableList of type Tournament.
   */
  public ObservableList<Tournament> readFromTournDB() {
    tournaments = FXCollections.observableArrayList();

    try {
      String tournSQL = "SELECT * FROM TOURNAMENT ";
      ResultSet rsTourn = DbUtils.getDb().getStmt().executeQuery(tournSQL);

      while (rsTourn.next()) {

        int id = rsTourn.getInt(DbUtils.TOURNAMENT_ID);
        String name = rsTourn.getString(DbUtils.TOURNAMENT_NAME);
        String date = rsTourn.getString(DbUtils.TOURNAMENT_START_DATE);
        String time = rsTourn.getString(DbUtils.TOURNAMENT_START_TIME);

        tournaments.add(new Tournament(id, name, date, time));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tournaments;
  }
}
