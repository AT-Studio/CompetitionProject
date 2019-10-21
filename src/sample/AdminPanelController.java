package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

  @FXML
  public void openTournManager() throws Exception {
    Main.loadNewView("admin-tourn-manager.fxml");
  }

  @FXML
  public void openUserSearch() {
    Main.loadNewView("searchProf.fxml");
  }
  @FXML
  public void returnToMenu(ActionEvent event) {
    Main.loadMainMenu();
  }

  @FXML
  public void verifyAdmin(){

    // If admin is verified then setVisible(true) to make the admin panel buttons visible

    tournManagerBtn.setVisible(true);
    searchUserBtn.setVisible(true);
  }
}