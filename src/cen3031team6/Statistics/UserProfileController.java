package cen3031team6.Statistics;

import cen3031team6.DataModels.User;
import cen3031team6.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * UserProfileController is a class which listens for user events in the userProfile.fxml view.
 *
 * @author Adam Dressel, Austin Nolz - The UserProfileController is the controller class for
 * userProfile.fxml, which populates the matchTable, tournTable, and user statistics. This class also
 * listens for the user selecting from the tournCombo to choose a tournament and view the respective
 * statistics.
 */
public class UserProfileController {

  @FXML
  private Label usernameLabel;

  @FXML
  private TableView matchTable;

  @FXML
  private TableView tournTable;

  private User currentUser;

  public void initialize() {

    //Populate tables with user statistics
    this.currentUser = SearchProfController.getSelectedUser();

    usernameLabel.setText(currentUser.getUsername());
  }

  /**
   * The back() method switches the screen to Stats.fxml.
   */
  @FXML
  public void back() {
    Main.loadNewView("./Statistics/Stats.fxml");
  }

  /**
   * The returnToMenu() method switches the screen to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }
}
