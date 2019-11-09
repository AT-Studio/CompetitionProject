package sample;

import java.util.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The TournSelectionController class updates and listens for user events within the
 * user-tourn-selection.fxml view.
 *
 * @author Austin Nolz - The TournSelectionController class
 */
public class TournSelectionController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments = null;

  public void initialize() {


  }

  /**
   * Switches the view to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * The user selects a tournament row within the tournTable and tourn-detail-page.fxml
   * is then loaded and the tournament information is displayed in labels in the view.
   */
  @FXML
  public void loadTournDetails() {

    /*
     * Loads the tourn-detail-page.fxml and populates the info labels with the selected Tournament
     * within the tournTable TableView.
     */

    Main.loadNewView("tourn-detail-page.fxml");
  }
}
