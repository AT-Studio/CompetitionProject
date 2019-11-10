package cen3031team6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.fxml.FXML;
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
  private TextField username;

  @FXML
  private TextField pw;

  @FXML
  private Label returnMsg;

  static Connection conn;

  static Statement stmt;

  @FXML
  public void login() {

    String userName = username.getText();
    String password = pw.getText();

    if (username.getText().equals("") || password.equals("")) {
      returnMsg.setText("Please enter your username and password.");
      returnMsg.setVisible(true);
      return;
    }
    boolean userExists = false;

    userExists = Main.searchDatabaseForUser(stmt, userExists, userName);

    if (!userExists) {
      returnMsg.setText("User does not exist.");
      returnMsg.setVisible(true);
    } else {
      returnMsg.setText("You are logged in as: " + userName);
      returnMsg.setVisible(true);
      returnToPreviousScene();
    }

  }

  @FXML
  public void signup(){

    Main.signUp(conn,stmt,username,
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
