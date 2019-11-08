package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.*;
import static sample.Utils.DbUtils.*;

/**
 * The LoginController class allows two users two log in or sign up, then if they both enter a
 * valid username and password the scene will be changed to score-entry.fxml.
 *
 * @author austinnolz The LoginController class will validate the entered username and password
 * if a user presses a log in button. If a user presses a sign up button this class creates a new
 * user account in the database if the username is unique. Once both users have signed up or logged
 * in the scene is switched to score-entry.fxml.
 */
public class LoginController {

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

  Connection conn;

  Statement stmt;

  public void initialize() {
    initializeDB();
  }

  public void initializeDB() {
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
   * entered username exists, then verifies if the entered password matches that username
   * in the database.
   */
  @FXML
  public void logInUser1(ActionEvent event) throws Exception {

    String userName = username1.getText();
    String password = pw1.getText();

    if (username1.getText().equals("") || pw1.getText().equals("")) {
      returnMsg1.setText("Please enter your username and password.");
      returnMsg1.setVisible(true);
      user1Ready = false;
      return;
    }

    try {
      String sql =
          "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      boolean userExists = false;
      while (rs.next()) {
        userExists = true;
        break;
      }

      // Checking to see if the username already exists in the database
      System.out.println("fetch size " + rs.getFetchSize());
      if (!userExists) {
        returnMsg1.setText("User does not exist.");
        returnMsg1.setVisible(true);
        user1Ready = false;
      } else {
        returnMsg1.setText("You are logged in as: " + userName);
        returnMsg1.setVisible(true);
        user1Ready = true;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    if (user1Ready && user2Ready) {
      loadScoreEntryView();
    }

  }

  /**
   * The signUpUser1() method will be called when user1 attempts to sign up. It verifies that the
   * entered username does not already exist, and if the username is unique the method will create
   * a new user account. User names require at least 8 characters and passwords require one
   * uppercase letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser1(ActionEvent event) throws Exception {

    // 1. Get entered username && password
    // 2. Query db to see if username is already taken
    // 3. if yes notify user
    // 4. if no create user with username and pw
    // 5. Let user know sign up was successful

    user1Ready = false;

    String userName = username1.getText();
    String password = pw1.getText();

    if (username1.getText().equals("") || pw1.getText().equals("")) {
      returnMsg1.setText("Please enter your username and password.");
      returnMsg1.setVisible(true);
      return;
    }

    try {
      String sql =
          "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      boolean userExists = false;
      while (rs.next()) {
        userExists = true;
        break;
      }

      // Checking to see if the username already exists in the database
      System.out.println("fetch size " + rs.getFetchSize());
      if (!userExists) {

        String sqlInsert =
            "INSERT INTO "
                + USER_TABLE_NAME
                + "("
                + USER_NAME
                + ", "
                + USER_PASSWORD
                + ")"
                + " VALUES(?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);

        preparedStatement.execute();

        returnMsg1.setText("User created.");
        returnMsg1.setVisible(true);
      } else {
        returnMsg1.setText("Username taken. Try again.");
        returnMsg1.setVisible(true);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * The logInUser2() method will be called when user 2 attempts to log in. It verifies if the
   * entered username exists, then verifies if the entered password matches that username in
   * the database.
   */
  @FXML
  public void logInUser2(ActionEvent event) throws Exception {

    String userName = username2.getText();
    String password = pw2.getText();

    if (username2.getText().equals("") || pw2.getText().equals("")) {
      returnMsg2.setText("Please enter your username and password.");
      returnMsg2.setVisible(true);
      user2Ready = false;
      return;
    }

    try {
      String sql =
          "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      boolean userExists = false;
      while (rs.next()) {
        userExists = true;
        break;
      }

      // Checking to see if the username already exists in the database
      System.out.println("fetch size " + rs.getFetchSize());
      if (!userExists) {
        returnMsg2.setText("User does not exist.");
        returnMsg2.setVisible(true);
        user2Ready = false;
      } else {
        returnMsg2.setText("You are logged in as: " + userName);
        returnMsg2.setVisible(true);
        user2Ready = true;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    if (user1Ready && user2Ready) {
      loadScoreEntryView();
    }

  }

  /**
   * The signUpUser2() method will be called when user 2 attempts to sign up. It verifies that the
   * entered username does not already exist, and if the username is unique the method will create
   * a new user account. User names require at least 8 characters and passwords require one
   * uppercase letter, one lowercase letter, and one number.
   */
  @FXML
  public void signUpUser2(ActionEvent event) throws Exception {

    user2Ready = false;

    String userName = username2.getText();
    String password = pw2.getText();

    if (username2.getText().equals("") || pw2.getText().equals("")) {
      returnMsg2.setText("Please enter your username and password.");
      returnMsg2.setVisible(true);
      return;
    }

    try {
      String sql =
          "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      boolean userExists = false;
      while (rs.next()) {
        userExists = true;
        break;
      }

      // Checking to see if the username already exists in the database
      System.out.println("fetch size " + rs.getFetchSize());
      if (!userExists) {

        String sqlInsert =
            "INSERT INTO "
                + USER_TABLE_NAME
                + "("
                + USER_NAME
                + ", "
                + USER_PASSWORD
                + ")"
                + " VALUES(?, ?)";

        PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);

        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);

        preparedStatement.execute();

        returnMsg2.setText("User created.");
        returnMsg2.setVisible(true);
      } else {
        returnMsg2.setText("Username taken. Try again.");
        returnMsg2.setVisible(true);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void loadScoreEntryView() {
    Main.loadNewView("score-entry.fxml");
  }
}
