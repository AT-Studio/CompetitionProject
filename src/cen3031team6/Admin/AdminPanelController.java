package cen3031team6.Admin;

import cen3031team6.Main;
import cen3031team6.Utils.DbUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The AdminPanelController class is the controller used to listen for user events in the
 * admin-panel.fxml view.
 *
 * @author Austin Nolz - The Admin Panel will show the TournamentPkg Manager button and the Search User
 * button if an administrator successfully logs in. Pressing the TournamentPkg Manager button will show
 * admin-tourn-manager.fxml and pressing the searchUserBtn will show searchProf.fxml.
 */
public class AdminPanelController {

  @FXML
  private TextField adminName;

  @FXML
  private PasswordField adminPW;

  @FXML
  private Button tournManagerBtn;

  @FXML
  private Button searchUserBtn;

  @FXML
  private Label returnMsg;

  public void initialize() {

  }

  /**
   * The openTournManager() method calls loadNewView in the Main class which switches the Scene to
   * admin-tourn-manager.fxml.
   */
  @FXML
  public void openTournManager() {
    Main.loadNewView("./Admin/admin-tourn-manager.fxml");
  }

  /**
   * Calls loadNewView() which switches the scene.
   */
  @FXML
  public void openUserSearch() {
    Main.loadNewView("./Statistics/searchProf.fxml");
  }

  /**
   * Calls loadMainMenu() which switches the scene to main-menu.fxml.
   */
  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  /**
   * The verifyAdmin() method checks if the entered username and password match any admin profile.
   */
  @FXML
  public void verifyAdmin() {
    String name = adminName.getText();
    String pw = adminPW. getText();

    try {
      String sql = "SELECT * FROM " + DbUtils.USER_TABLE_NAME + " WHERE "
              + DbUtils.USER_NAME + " = '" + name + "'";
      ResultSet set = DbUtils.getDb().getStmt().executeQuery(sql);

      if (set.next()) {
        if (!set.getString(DbUtils.USER_PASSWORD).equals(pw)) {
          tournManagerBtn.setVisible(false);
          searchUserBtn.setVisible(false);
          returnMsg.setText("Incorrect password");
          returnMsg.setVisible(true);
        } else if (!set.getBoolean(DbUtils.USER_IS_ADMIN)) {
          tournManagerBtn.setVisible(false);
          searchUserBtn.setVisible(false);
          returnMsg.setText("User is not an admin");
          returnMsg.setVisible(true);
        } else {
          returnMsg.setVisible(false);
          tournManagerBtn.setVisible(true);
          searchUserBtn.setVisible(true);
        }
      } else {
        tournManagerBtn.setVisible(false);
        searchUserBtn.setVisible(false);
        returnMsg.setText("User does not exist");
        returnMsg.setVisible(true);
      }

      set.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}