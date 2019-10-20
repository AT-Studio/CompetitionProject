package sample;

import javafx.fxml.FXML;

public class TournDetailPageController {

  public void initialize() {

  }

  @FXML
  public void loadBracketView() {
    Main.loadNewView("bracket-view.fxml");

  }
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }


}
