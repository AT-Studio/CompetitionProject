package cen3031team6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The SingleUserLoginController updates single-user-login.fxml and listens for updates within
 * this view.
 *
 * @author Austin Nolz - The SingleUserLoginController class prompts the user to sign up or log in
 * so they can access a feature of the application.
 */
public class SingleUserLoginController {

  @FXML
  private TextField usernameTextField;

  @FXML
  private TextField pw;

  @FXML
  private Label returnMsg;

  static Connection conn;

  static Statement stmt;

  @FXML
  public void login() {

    String userName = usernameTextField.getText();
    String password = pw.getText();

    if (usernameTextField.getText().equals("") || password.equals("")) {
      returnMsg.setText("Please enter your usernameTextField and password.");
      returnMsg.setVisible(true);
      return;
    }
    boolean userExists = false;
    boolean pwIsCorrect = false;

    userExists = Main.searchDatabaseForUser(stmt, userExists, userName);

    if (!userExists) {
      returnMsg.setText("User does not exist.");
      returnMsg.setVisible(true);
    } else {

      pwIsCorrect = Main.verifyPassword(stmt,pwIsCorrect,userName, password);

    if(pwIsCorrect) {
      returnMsg.setText("You are logged in as: " + userName);
      returnMsg.setVisible(true);
      returnToPreviousScene();
    } else {
      returnMsg.setText("Incorrect password.");
      returnMsg.setVisible(true);
    }
    }

  }

  @FXML
  public void signup(){

    Main.signUp(conn,stmt, usernameTextField,
        pw, returnMsg);
  }

  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  public void initialize() {
    initializeDB();
  }

  public static void initializeDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/pongdb";

    final String USER = "";
    final String PASS = "";

    try {
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void returnToPreviousScene() {

    Main.loadNewView(Main.getPreviousFXML());
  }
}
