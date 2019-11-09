package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

/**
 * MyProfileController is a class which listens for user events in the myProfile.fxml view.
 *
 * @author Adam Dressel, Austin Nolz - The MyProfileController is the controller class for
 * myProfile.fxml, which populates the matchTable, tournTable, and user statistics. This class also
 * listens for the user selecting from the tournCombo to choose a tournament and view the respective
 * statistics.
 */
public class MyProfileController {

  @FXML
  private ComboBox tournCombo;

  @FXML
  private TableView matchTable;

  @FXML
  private TableView tournTable;

  public void initialize() {
  }

  /**
   * The back() method switches the screen to Stats.fxml.
   */
  @FXML
  public void back() {
    Main.loadNewView("Stats.fxml");
  }

  /**
   * The returnToMenu() method switches the screen to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }
}
