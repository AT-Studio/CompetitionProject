package sample;

import java.util.Date;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TournSelectionController {

  @FXML
  private TableView tournTable = new TableView();
  private ObservableList<Tournament> tournaments = null;

  public void initialize() {

    Main.addTournColumns(tournTable);

  }

  @FXML
  public void returnToMenu() {
    Main.loadMainMenu();
  }

  @FXML
  public void loadTournDetails() {
  Main.loadNewView("tourn-detail-page.fxml");
  }
}
