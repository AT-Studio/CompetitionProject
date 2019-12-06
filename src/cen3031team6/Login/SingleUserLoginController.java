package cen3031team6.Login;

import cen3031team6.Main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The SingleUserLoginController updates single-user-login.fxml and listens for updates within this
 * view.
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

  /**
   * The login() method is called when the user presses the Log In button. It first checks if the
   * user entered a username and password, then verifies if the username exists. If it does, then
   * the password is verified.
   */
  @FXML
  public void login() {

    String userName = usernameTextField.getText();
    String password = pw.getText();

    if (userName.equals("") || password.equals("")) {
      returnMsg.setText("Please enter your username and password.");
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

      pwIsCorrect = Main.verifyPassword(stmt, pwIsCorrect, userName, password);

      if (pwIsCorrect) {
        returnMsg.setText("You are logged in as: " + userName);
        returnMsg.setVisible(true);
        returnToPreviousScene();
      } else {
        returnMsg.setText("Incorrect password.");
        returnMsg.setVisible(true);
      }
    }
  }

  /**
   * This method calls signUp within Main.
   */
  @FXML
  public void signup() {

    Main.signUp(conn, stmt, usernameTextField,
        pw, returnMsg);
  }

  /**
   * This method switches the scene to main-menu.fxml.
   */
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

  /**
   * This view was originally loaded from two separate points so this method would return to the
   * previous scene.
   */
  public void returnToPreviousScene() {

    Main.loadNewView(Main.getPreviousFXML());
  }
}
