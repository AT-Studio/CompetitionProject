package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class AdminPanelController {

  @FXML
  private TextField adminName;

  @FXML
  private TextField adminPW;

  public void initialize() {

  }

  @FXML
  public void openTournManager() {
    loadNewView("admin-tourn-manager.fxml");
  }

  private void loadNewView(String fxml) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource(fxml));
      Main.setCurrentScene(new Scene(root, 600, 400));

      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    Main.loadMainMenu();
  }
}
