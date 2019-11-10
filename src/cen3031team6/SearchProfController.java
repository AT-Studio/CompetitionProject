package cen3031team6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * The SearchProfController class updates and listens for changes within the searchProf.fxml view.
 *
 * @authors Adam Dressel, Austin Nolz - The SearchProfController populates the userTable with all
 * usernames stored by default. Once a player types a username into the usernameField and presses
 * the Search button, the method searchUser() is called which finds matching usernames and updates
 * the userTable with the results from the database query.
 */
public class SearchProfController {

  @FXML
  private TableView<User> userTable = new TableView<>();

  @FXML
  private TextField usernameField;

  public void initialize() {
    //Populate userTable view with full user list
  }

  /**
   * The searchUser() method is called onAction of the Search button, which executes a query to find
   * all matching usernames.
   */
  @FXML
  public void searchUser() {

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
  public void returnToMenu(ActionEvent event) throws Exception {
    Main.loadMainMenu();
  }

}
