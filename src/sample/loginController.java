package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController {

  @FXML
  private TextField username1;

  @FXML
  private TextField username2;

  @FXML
  private TextField pw1;

  @FXML
  private TextField pw2;

  @FXML
  private Button user1Login;

  @FXML
  private Button user2Login;

  @FXML
  private Button user1SignUp;

  @FXML
  private Button user2SignUp;

  @FXML
  private Label returnMsg1;

  @FXML
  private Label returnMsg2;

  @FXML
  private Button backBtn;

  public void initialize() {

  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    try {
      Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
      Scene mainMenuScene = new Scene(mainMenuRoot, 600, 400);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(mainMenuScene);

      stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
