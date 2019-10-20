package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

  public void initialize() {

  }

  @FXML
  public void openVersusMenu(ActionEvent event) throws Exception {

    Main.loadNewView("login.fxml");
  }

  @FXML
  public void openTournMenu() {

  }

  @FXML
  public void openStatsMenu() {

  }

  @FXML
  public void openAdminMenu() throws Exception {
    Main.loadNewView("admin-panel.fxml");
  }

}