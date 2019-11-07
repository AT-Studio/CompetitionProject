package sample;

import java.util.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * The tourSelectionController allows you to create or select different tournaments, view tournament details and gives you an
 * option to return to the main menu.
 */

public class TournSelectionController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments = null;

  public void initialize() {
    Main.addTournColumns(tournTable);

  }

  /**
   * return to Main Menu
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();

  }

  /**
   * load tournament details
   */
  @FXML
  public void loadTournDetails() {
    Main.loadNewView("tourn-detail-page.fxml");
  }

}
