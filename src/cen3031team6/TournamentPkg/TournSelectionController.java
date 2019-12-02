package cen3031team6.TournamentPkg;

import cen3031team6.Main;
import cen3031team6.DataModels.Tournament;

import java.sql.*;
import java.time.format.DateTimeFormatter;

import cen3031team6.Utils.DbUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The TournSelectionController class updates and listens for user events within the
 * user-tourn-selection.fxml view.
 *
 * @author Austin Nolz - The TournSelectionController class
 */
public class TournSelectionController {

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

  @FXML
  private Label returnMsg;

  @FXML
  private Label returnMsg1;

  public static TournamentHolder tournamentDetails = new TournamentHolder();

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
   * The user selects a tournament row within the tournTable and tourn-detail-page.fxml is then
   * loaded and the tournament information is displayed in labels in the view.
   */
  @FXML
  public void loadTournDetails(ActionEvent actionEvent) {
    Tournament selected = tournTable.getSelectionModel().getSelectedItem();

    if (selected != null) {
      tournamentDetails.setTournamentName(selected.getTournamentName());
      tournamentDetails.setTournamentDate(selected.getStartDate());
      tournamentDetails.setTournamentStartTime(selected.getStartTime());

      Main.loadNewView("./TournamentPkg/tourn-detail-page.fxml");
    } else {
      returnMsg.setVisible(true);
    }
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
    } else{
      returnMsg1.setVisible(true);
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
    ObservableList<Tournament> show = FXCollections.observableArrayList();

    try {
      String tournSQL = "SELECT NAME, START_DATE, START_TIME FROM TOURNAMENT ";
      ResultSet rsTourn = DbUtils.getDb().getStmt().executeQuery(tournSQL);

      while (rsTourn.next()) {
        String name = rsTourn.getString("NAME");
        String date = rsTourn.getString("START_DATE");
        String time = rsTourn.getString("START_TIME");

        show.add(new Tournament(name, date, time));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return FXCollections.observableArrayList(show);
  }
}
