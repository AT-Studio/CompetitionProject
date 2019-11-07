package sample;

import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The AdminTournManagerController class is the controller for the admin-tourn-manager.fxml view.
 */
public class AdminTournManagerController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments = null;

  public void initialize() {

    Main.addTournColumns(tournTable);

    if(tournaments == null) {
      tournTable.getItems().add(new Tournament("Ping Pong#1", new Date(), "1:00 PM"));
    }
  }

  /**
   * The returnToMenu() class
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

}
