package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StatsController {

  @FXML
  public void openLeaderboard() {
    Main.loadNewView("leaderboard.fxml");
  }

  @FXML
  public void searchProfile() {
    Main.loadNewView("searchProf.fxml");
  }

  public void back() {
    Main.loadNewView("main-menu.fxml");
  }
}
