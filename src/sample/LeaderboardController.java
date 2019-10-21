package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class LeaderboardController {

  @FXML
  private ChoiceBox<String> lbChoiceBox;

  public void initialize() {
    lbChoiceBox.getItems().add("Overall Leaderboard");
    lbChoiceBox.getItems().add("Tournament Leaderboard");

  }

  public void back(){
    Main.loadNewView("Stats.fxml");
  }

  @FXML
  public void returnToMenu(ActionEvent event) throws Exception{
    Main.loadMainMenu();
  }

}
