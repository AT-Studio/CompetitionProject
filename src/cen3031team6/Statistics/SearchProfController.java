package cen3031team6.Statistics;

import cen3031team6.DataModels.User;
import cen3031team6.Main;
import cen3031team6.Utils.DbUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The SearchProfController class updates and listens for changes within the searchProf.fxml view.
 *
 * @authors Alexander Thieler, Adam Dressel, Austin Nolz - The SearchProfController populates the
 * userTable with all usernames stored by default. Once a player types a username into the
 * usernameField and presses the Search button, the method searchUser() is called which finds
 * matching usernames and updates the userTable with the results from the database query.
 */
public class SearchProfController {

  @FXML
  private TableView<User> userTable = new TableView<>();

  @FXML
  private TextField usernameField;

  @FXML
  private Label selectProfileLabel;

  @FXML
  private Button viewProfileBtn;

  private static User selectedUser;

  public void initialize() {

    searchUser();

    viewProfileBtn.setOnAction(event -> {
      setSelectedUser(userTable.getSelectionModel().getSelectedItem());

      if (selectedUser == null) {
        selectProfileLabel.setVisible(true);
      } else {
        //load userProfileController with the data of the selected User.
        Main.loadNewView("./Statistics/userProfile.fxml");

        //Populate userProfile.fxml with selected User data from database
      }
    });
  }

  /**
   * The searchUser() method is called onAction of the Search button, which executes a query to find
   * all matching usernames.
   */
  @FXML
  public void searchUser() {
    String searchText = usernameField.getText();
    ObservableList<User> users = FXCollections.observableArrayList();
    try {
      String sql = "SELECT * FROM " + DbUtils.USER_TABLE_NAME +
          " WHERE " + DbUtils.USER_NAME + " LIKE '%" + searchText + "%'";
      ResultSet set = DbUtils.getDb().getStmt().executeQuery(sql);

      while (set.next()) {
        String username = set.getString(DbUtils.USER_NAME);
        users.add(new User(username));
      }

      set.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    userTable.setItems(users);

  }

  /**
   * The back() method switches the screen to Stats.fxml.
   */
  @FXML
  public void back() {
    Main.loadNewView("./Statistics/Stats.fxml");
  }

  /**
   * The returnToMenu() method switches the screen to main-menu.fxml.
   */
  @FXML
  public void returnToMenu(ActionEvent event) throws Exception {
    Main.loadMainMenu();
  }

  public static User getSelectedUser() {
    return selectedUser;
  }

  public void setSelectedUser(User selectedUser) {
    this.selectedUser = selectedUser;
  }
}
