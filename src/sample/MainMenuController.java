package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

  public void initialize() {

  }

  @FXML
  public void openVersusMenu(ActionEvent event) {

    Main.loadNewView("Match1v1.fxml");
  }

  @FXML
  public void openTournMenu() {
    Main.loadNewView("user-tourn-selection.fxml");
  }

  @FXML
  public void openStatsMenu() {
    Main.loadNewView("Stats.fxml");
  }

  @FXML
  public void openAdminMenu(ActionEvent event) {
    Main.loadNewView("admin-panel.fxml");
  }

}