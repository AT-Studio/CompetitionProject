package cen3031team6.TournamentPkg;

import cen3031team6.Main;
import cen3031team6.DataModels.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * The TournDetailPageController is the class which updates and listens for user events
 * within the tourn-detail-page.fxml view.
 *
 * @author Austin Nolz - The TournDetailPageController populates labels with the tournament details,
 * adds the user list to the tableview, allows a user to join or leave a tournament with valid
 * log in information.
 */
public class TournDetailPageController {

  @FXML
  private Label tournNameLabel;

  @FXML
  private Label startDateLabel;

  @FXML
  private Label startTimeLabel;

  @FXML
  private Label userNumLabel;

  @FXML
  private TableView<User> tournUserTable = new TableView<>();

  private ObservableList<User> userList;

  public void initialize() {

    /*
     * Set the labels for tournament name, start date, start time, and number of users
     * from the TournamentPkg object.
     */


    tournNameLabel.setText("FGCU SEC 2019");
    startDateLabel.setText("12/01/2019");
    startTimeLabel.setText("1:00PM");
    userNumLabel.setText("8");

    userList = FXCollections.observableArrayList();
    userList.add(new User("Alex"));
    userList.add(new User("Amanda"));
    userList.add(new User("Adam"));
    userList.add(new User("Oscar"));
    userList.add(new User("Jon"));
    userList.add(new User("Austin"));
    tournUserTable.setItems(userList);

  }

  /**
   * This method is called when the user presses the Join button and then prompts the user to
   * sign in.
   */
  @FXML
  public void joinTourn() {

    // if(currentNumberOfUsers < maxNumberOfUsers) to check if there are any open spots

    Main.loadNewView("./Login/single-user-login.fxml");
    Main.setPreviousFXML("./TournamentPkg/tourn-detail-page.fxml");

    /*
     * We need to add logic within SingleUserLoginController to add the user if they successfully
     * log in.
     */
  }

  /**
   * This method is called when the user presses the Leave button and then prompts the user
   * to sign in.
   */
  @FXML
  public void leaveTourn() {

    // if (currentDateTime < startDateTime)   checks if the startDate and time has elapsed.

    Main.loadNewView("./Login/single-user-login.fxml");
    Main.setPreviousFXML("./TournamentPkg/tourn-detail-page.fxml");

    /*
     * We need to add logic within SingleUserLoginController to remove the user if they successfully
     * login.
     */
  }

  /**
   * The loadBracketView() method is called when a user attempts to Start a tournament. The
   * tournament will only begin and load bracket-view.fxml if the number of users
   * signed up is equal to 4, and the start date and time has elapsed.
   */
  @FXML
  public void loadBracketView() {
    /*
     * I need to set up conditionals to ensure that we load the
     * Bracket view and start the tournament only if there are 4 users
     * signed up for the tournament and the start date/time must have elapsed.
     *
     * if( Integer.parseInt(userNumLabel.getText()) = 4 && (Current Date/Time > Start Date/Time))
     *       Main.loadNewView("bracket-view.fxml");
     *
     */

    Main.loadNewView("./TournamentPkg/bracket-view.fxml");

  }

  /**
   * This method switches the scene back to the main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * Switches the scene to main-menu.fxml when the user presses the Back button.
   */
  @FXML
  public void back() {
    Main.loadNewView("./TournamentPkg/user-tourn-selection.fxml");
  }
}
