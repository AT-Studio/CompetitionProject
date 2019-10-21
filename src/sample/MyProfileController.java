package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class MyProfileController {

  @FXML
  private ComboBox tournCombo;

  public void initialize() {}

  @FXML
  public void back() {
    Main.loadNewView("Stats.fxml");
  }

  @FXML
  public void returnToMenu() { Main.loadMainMenu();}
}
