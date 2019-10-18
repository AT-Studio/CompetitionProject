package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

  @FXML
  private Button adminBtn;
  @FXML
  private Button statsBtn;
  @FXML
  private Button versusBtn;
  @FXML
  private Button tournBtn;


  public void initialize() {

  }

  @FXML
  public void openVersusMenu(ActionEvent event) {

    try {
      Parent loginRoot = FXMLLoader.load(getClass().getResource("login.fxml"));
      Scene tableViewScene = new Scene(loginRoot, 560, 360);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

      stage.setScene(tableViewScene);

      stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
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
}