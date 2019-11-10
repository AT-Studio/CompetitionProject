package cen3031team6;

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

  public void initialize() {

    tournaments = FXCollections.observableArrayList();

    tournaments.add(new Tournament("FGCU SEC 2019",
        new Date(), "1:00 PM"));
    tournTable.setItems(tournaments);

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
  public void loadTournDetails() {

    /*
     * Loads the tourn-detail-page.fxml and populates the info labels with the selected Tournament
     * within the tournTable TableView.
     */

    Main.loadNewView("tourn-detail-page.fxml");
  }
}
