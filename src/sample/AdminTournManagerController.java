package sample;

import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminTournManagerController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments = null;

  public void initialize() {

    TableColumn<String, Tournament> tournNameColumn = new TableColumn<>("Tournament Name");
    tournNameColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));

    TableColumn<Date, Tournament> startDateColumn = new TableColumn<>("Start Date");
    startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

    TableColumn<String, Tournament> startTimeColumn = new TableColumn<>("Start Time");
    tournNameColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));

    tournTable.getColumns().add(tournNameColumn);
    tournTable.getColumns().add(startDateColumn);
    tournTable.getColumns().add(startTimeColumn);

    if(tournaments == null) {
      tournTable.getItems().add(new Tournament("Ping Pong#1", new Date(), "1:00 PM"));
    }
  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    Main.loadMainMenu();
  }
}
