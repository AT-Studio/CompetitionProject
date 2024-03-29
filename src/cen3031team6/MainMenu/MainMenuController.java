package cen3031team6.MainMenu;

import cen3031team6.Main;
import javafx.fxml.FXML;

/**
 * The MainMenuController class listens for user events within the main-menu.fxml view.
 *
 * @author Adam Dressel - The MainMenuController class has buttons to start a 1v1 match, to open the
 * TournamentPkg Menu, to open the stats menu, or open the Administrator menu.
 */
public class MainMenuController {

  public void initialize() {

  }

  /**
   * This method switches the scene to one-v-one-login.fxml.
   */
  @FXML
  public void openVersusMenu() {

    Main.loadNewView("./Login/one-v-one-login.fxml");
  }

  /**
   * This method switches the scene to user-tourn-selection.fxml.
   */
  @FXML
  public void openTournMenu() {
    Main.loadNewView("./TournamentPkg/user-tourn-selection.fxml");
  }

  /**
   * This method switches the scene to Stats.fxml.
   */
  @FXML
  public void openStatsMenu() {
    Main.loadNewView("./Statistics/Stats.fxml");
  }

  /**
   * This method switches the scene to admin-panel.fxml.
   */
  @FXML
  public void openAdminMenu() {
    Main.loadNewView("./Admin/admin-panel.fxml");
  }

}