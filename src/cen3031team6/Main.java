package cen3031team6;

import static cen3031team6.Utils.DbUtils.USER_NAME;
import static cen3031team6.Utils.DbUtils.USER_PASSWORD;
import static cen3031team6.Utils.DbUtils.USER_TABLE_NAME;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

  private static Stage stage;
  private static String previousFXML;
  private static Scene currentScene;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("main-menu.fxml"));
    setStage(primaryStage);
    primaryStage.setTitle("Ping Pong Party");
    currentScene = new Scene(root, 600, 400);
    primaryStage.setScene(currentScene);
    primaryStage.show();

    // hi in dev

  }

  public static void main(String[] args) {
    launch(args);
  }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    Main.stage = stage;
  }

  public static Scene getCurrentScene() {
    return currentScene;
  }

  public static void setCurrentScene(Scene scene) {
    Main.currentScene = scene;
  }

  public static String getPreviousFXML() {
    return previousFXML;
  }

  public static void setPreviousFXML(String previousFXML) {
    Main.previousFXML = previousFXML;
  }

  /**
   * Switches the scene to main-menu.fxml.
   */
  public static void loadMainMenu() {
    try {
      Parent mainMenuRoot = FXMLLoader.load(Main.class.getResource("main-menu.fxml"));
      Main.setCurrentScene(new Scene(mainMenuRoot, 600, 400));
      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * The method loadNewView() is called to change the scene to the fxml file and the file name is
   * passed as a String parameter.
   * @param fxml - String of the fxml file name.
   */
  protected static void loadNewView(String fxml) {
    try {

      Parent root = FXMLLoader.load(Main.class.getResource(fxml));
      Main.setCurrentScene(new Scene(root, 600, 400));

      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * The signUp method is called from other methods to add the entered username
   * and password to the database.
   *
   * @param conn - Connection object
   * @param stmt - Statement object
   * @param username - Username
   * @param pw- password
   * @param returnMsg - Feedback label.
   */
  protected static void signUp(Connection conn, Statement stmt,
      TextField username, TextField pw, Label returnMsg) {

    // 1. Get entered username && password
    // 2. Query db to see if username is already taken
    // 3. if yes notify user
    // 4. if no create user with username and pw
    // 5. Let user know sign up was successful

    String userName = username.getText();
    String password = pw.getText();

    if (userName.equals("") || password.equals("")) {
      returnMsg.setText("Please enter your username and password.");
      returnMsg.setVisible(true);
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

        returnMsg.setText("User created.");
        returnMsg.setVisible(true);
      } else {
        returnMsg.setText("Username taken. Try again.");
        returnMsg.setVisible(true);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  protected static boolean searchDatabaseForUser(Statement stmt, boolean userExists, String userName) {
    try {
      String sql =
          "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      while (rs.next()) {
        userExists = true;
        break;
      }

      // Checking to see if the username already exists in the database
      System.out.println("fetch size " + rs.getFetchSize());


    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userExists;
  }

  /**
   * The verifyPassword() method checks if the entered password matches the password stored in the
   * database for the entered username.
   *
   * @param stmt - Database Statement object
   * @param pwIsCorrect -boolean value to show the entered pw is correct for the entered username
   * @param userName - entered username which was found in the database.
   * @param enteredPW - The entered password.
   * @return - The value of pwIsCorrect is returned to flag if the entered pw is verified.
   */
  protected static boolean verifyPassword(Statement stmt, boolean pwIsCorrect, String userName,
      String enteredPW) {
    String databasePW;
    try {
      String sql =
          "SELECT PASSWORD FROM " + USER_TABLE_NAME + " WHERE " + USER_NAME + " = '" + userName + "'";

      System.out.println("sql: " + sql);

      ResultSet rs = stmt.executeQuery(sql);

      rs.next();
      databasePW = rs.getString(1);
      System.out.println(databasePW);

      if(enteredPW.equals(databasePW)) {
        pwIsCorrect = true;

      }


    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pwIsCorrect;
  }
}