package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ScoreEntryController {

  @FXML
  private Label user1Label;

  @FXML
  private Label user2Label;

  @FXML
  private TextField user1Score;

  @FXML
  private TextField user2Score;

  @FXML
  public void returnToMenuFromScore(ActionEvent event) {
    try {
      Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
      Main.setCurrentScene(new Scene(mainMenuRoot, 600, 400));
      Main.getStage().setScene(Main.getCurrentScene());
      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void iniitialize() {


  }

}
