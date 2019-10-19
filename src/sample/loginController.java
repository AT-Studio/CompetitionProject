package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
  private Label returnMsg1;

  @FXML
  private Label returnMsg2;

  private boolean user1Ready = false;

  private boolean user2Ready = false;


  public void initialize() {

  }

  @FXML
  public void returnToMenu(ActionEvent event) {
    try {
      Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
      Main.setCurrentScene(new Scene(mainMenuRoot, 600, 400));
      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * The logInUser1() method will be called when user 1 attempts to log in. It verifies if the entered username
   * exists, then verifies if the entered password matches that username in the databse.
   */
  @FXML
  public void logInUser1(ActionEvent event) {

    if(username1.getText().equals("") || pw1.getText().equals("")){
      returnMsg1.setText("Please enter your username and password.");
      returnMsg1.setVisible(true);
    } else {
      returnMsg1.setText("User 1 is ready.");
      user1Ready = true;
    }

    if(user1Ready && user2Ready){
      loadScoreEntryView(event);
    }
  }

  /**
   * The signUpUser1() method will be called when user1 attempts to sign up. It verifies that the entered
   * username does not already exist, and if the username is unique the method will create a new
   * user account. User names require at least 8 characters and passwords require one uppercase
   * letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser1(ActionEvent event) {

    if(username1.getText().equals("") || pw1.getText().equals("")){
      returnMsg1.setText("Please enter your username and password.");
      returnMsg1.setVisible(true);
    }
    // else if username already exists, set return message to "Username taken"
    //

    else{
      //Insert new user into database
      //

      returnMsg1.setText("Account created, User 1 is ready.");
      user1Ready = true;
    }

    if(user1Ready && user2Ready){
      loadScoreEntryView(event);
    }
  }

  /**
   * The logInUser2() method will be called when user 2 attempts to log in. It verifies if the entered username
   * exists, then verifies if the entered password matches that username in the databse.
   */
  @FXML
  public void logInUser2(ActionEvent event) {

    if(username2.getText().equals("") || pw2.getText().equals("")){
      returnMsg2.setText("Please enter your username and password.");
      returnMsg2.setVisible(true);
    } else {
      returnMsg2.setText("User 2 is ready.");
      user2Ready = true;
    }

    if(user1Ready && user2Ready){
      loadScoreEntryView(event);
    }
  }

  /**
   * The signUpUser2() method will be called when user 2 attempts to sign up. It verifies that the entered
   * username does not already exist, and if the username is unique the method will create a new
   * user account. User names require at least 8 characters and passwords require one uppercase
   * letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser2(ActionEvent event) {
    //Username2.getText() check if the entered username already exists in database
    // if username already exists, set return message to "Username taken"
    //

    if(username2.getText().equals("") || pw2.getText().equals("")){
      returnMsg2.setText("Please enter your username and password.");
      returnMsg2.setVisible(true);
    }
    else{
      //Insert new user into database
      //

      returnMsg2.setText("Account created, User 2 is ready.");
      user2Ready = true;
    }

    if(user1Ready && user2Ready){
      loadScoreEntryView(event);
    }
  }

  public void loadScoreEntryView(ActionEvent event){
    try {
      Parent scoreEntryRoot = FXMLLoader.load(getClass().getResource("score-entry.fxml"));
      Main.setCurrentScene(new Scene(scoreEntryRoot, 600, 400));
      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
