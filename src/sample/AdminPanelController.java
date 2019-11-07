package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The AdminPanelController class is the controller used to listen for user events in the
 * admin-panel.fxml view.
 *
 * @author austinnolz - The Admin Panel will show the Tournament Manager button and the Search User
 * button if an administrator successfully logs in. Pressing the Tournament Manager button will
 * show admin-tourn-manager.fxml and pressing the searchUserBtn will show searchProf.fxml.
 */
public class AdminPanelController {

  @FXML
  private TextField adminName;

  @FXML
  private TextField adminPW;

  @FXML
  private Button tournManagerBtn;

  @FXML
  private Button searchUserBtn;

  public void initialize() {

  }

  /**
   * The openTournManager() method calls loadNewView in the Main class which switches the Scene
   * to admin-tourn-manager.fxml.
   */
  @FXML
  public void openTournManager() {
    Main.loadNewView("admin-tourn-manager.fxml");
  }

  /**
   * Calls loadNewView() which switches the scene
   */
  @FXML
  public void openUserSearch() {
    Main.loadNewView("searchProf.fxml");
  }

  /**
   * Calls loadMainMenu() which switches the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * The verifyAdmin() method checks if the entered username and password match any admin profile.
   */
  @FXML
  public void verifyAdmin(){

    // If admin is verified then setVisible(true) to make the admin panel buttons visible

    tournManagerBtn.setVisible(true);
    searchUserBtn.setVisible(true);
  }
}