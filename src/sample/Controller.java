package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Controller {

  public void initialize() {

  }

  @FXML
  public void openVersusMenu(ActionEvent event) {

    loadNewView(event,"login.fxml");
  }

  @FXML
  public void openTournMenu() {

  }

  @FXML
  public void openStatsMenu() {

  }

  @FXML
  public void openAdminMenu() {

  }

  public void loadNewView(ActionEvent event, String fxml) {
    try {
      Parent root = FXMLLoader.load(Main.class.getResource(fxml));
      Main.setCurrentScene(new Scene(root, 560, 360));

      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}