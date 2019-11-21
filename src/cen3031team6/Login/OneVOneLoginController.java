package cen3031team6.Login;

import cen3031team6.Main;
import cen3031team6.DataModels.OneVOneStats;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;

/**
 * The OneVOneLoginController class allows two users two log in or sign up, then if they both enter
 * a valid username and password the scene will be changed to score-entry.fxml.
 *
 * @authors Oscar Garcia, Alexander Thieler, Austin Nolz - The OneVOneLoginController class will
 * validate the entered username and password if a user presses a log in button. If a user presses a
 * sign up button this class creates a new user account in the database if the username is unique.
 * Once both users have signed up or logged in the scene is switched to score-entry.fxml.
 */
public class OneVOneLoginController {

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

  public static OneVOneStats matchStats = new OneVOneStats();

  public static Connection conn;

  public static Statement stmt;

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

  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * The logInUser1() method will be called when user 1 attempts to log in. It verifies if the
   * entered username exists, then verifies if the entered password matches that username in the
   * database.
   */
  @FXML
  public void logInUser1() {

    String userName = username1.getText();
    String password = pw1.getText();

    if (userName.equals("") || password.equals("")) {
      returnMsg1.setText("Please enter your username and password.");
      returnMsg1.setVisible(true);
      user1Ready = false;
      return;
    }
    boolean userExists = false;
    boolean pwIsCorrect = false;

    userExists = Main.searchDatabaseForUser(stmt, userExists, userName);

    if (!userExists) {
      returnMsg1.setText("User does not exist.");
      returnMsg1.setVisible(true);
      user1Ready = false;
    } else {

      pwIsCorrect = Main.verifyPassword(stmt,pwIsCorrect,userName, password);

      if(pwIsCorrect) {
      returnMsg1.setText("You are logged in as: " + userName);
      returnMsg1.setVisible(true);
      user1Ready = true;
      matchStats.setUserNameOne(username1.getText());
    } else{
      returnMsg1.setText("Incorrect password.");
      returnMsg1.setVisible(true);
    }
    }

    if (user1Ready && user2Ready) {
      loadScoreEntryView();
    }

  }

  /**
   * The signUpUser1() method will be called when user1 attempts to sign up. It verifies that the
   * entered username does not already exist, and if the username is unique the method will create a
   * new user account. User names require at least 8 characters and passwords require one uppercase
   * letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser1() {

    Main.signUp(conn, stmt, username1, pw1, returnMsg1);
  }

  /**
   * The logInUser2() method will be called when user 2 attempts to log in. It verifies if the
   * entered username exists, then verifies if the entered password matches that username in the
   * database.
   */
  @FXML
  public void logInUser2() {

    String userName = username2.getText();
    String password = pw2.getText();

    if (userName.equals("") || password.equals("")) {
      returnMsg2.setText("Please enter your username and password.");
      returnMsg2.setVisible(true);
      user2Ready = false;
      return;
    }
    boolean userExists = false;
    boolean pwIsCorrect = false;

    userExists = Main.searchDatabaseForUser(stmt, userExists, userName);

    if (!userExists) {
      returnMsg2.setText("User does not exist.");
      returnMsg2.setVisible(true);
      user2Ready = false;
    } else {


      pwIsCorrect = Main.verifyPassword(stmt,pwIsCorrect,userName, password);

      if(pwIsCorrect) {

        returnMsg2.setText("You are logged in as: " + userName);
        returnMsg2.setVisible(true);
        user2Ready = true;
        matchStats.setUserNameTwo(username2.getText());
      } else{
        returnMsg2.setText("Incorrect password.");
        returnMsg2.setVisible(true);
      }
    }

    if (user1Ready && user2Ready) {
      loadScoreEntryView();
    }

  }

  /**
   * The signUpUser2() method will be called when user 2 attempts to sign up. It verifies that the
   * entered username does not already exist, and if the username is unique the method will create a
   * new user account. User names require at least 8 characters and passwords require one uppercase
   * letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser2() {
    Main.signUp(conn, stmt, username2, pw2, returnMsg2);

  }

  public void loadScoreEntryView() {
    Main.loadNewView("./ScoreEntry/score-entry.fxml");
  }
}
