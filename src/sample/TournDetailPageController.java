package sample;

import javafx.event.ActionEvent;
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

  @FXML
  public void back() {
    Main.loadNewView("user-tourn-selection.fxml");
  }


}
