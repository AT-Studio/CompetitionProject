package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AdminPanelController {

  @FXML
  private TextField adminName;

  @FXML
  private TextField adminPW;

  public void initialize() {

  }

  @FXML
  public void openTournManager() throws Exception {
    Main.loadNewView("admin-tourn-manager.fxml");
  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    Main.loadMainMenu();
  }
}