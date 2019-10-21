package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BracketViewController {

  @FXML
  private Label user1Label;

  @FXML
  private Label user2Label;

  public void Initialize() {

  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    Main.loadMainMenu();
  }
}
