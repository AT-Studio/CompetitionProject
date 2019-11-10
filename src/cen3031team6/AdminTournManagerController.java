package cen3031team6;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 * The AdminTournManagerController class is the controller for the admin-tourn-manager.fxml view.
 *
 * @author Austin Nolz - The AdminTournManagerController populates the tournTable, which shows all
 * tournaments in the database. An administrator can press the create button to make a new
 * tournament, or press the delete button to remove a tournament from the database and tournTable.
 */
public class AdminTournManagerController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments;

  public void initialize() {

  }

  /**
   * The returnToMenu() class switches the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

}
