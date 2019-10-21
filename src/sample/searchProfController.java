package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class searchProfController {

  @FXML
  public void back(){
    Main.loadNewView("Stats.fxml");
  }

  @FXML
  public void returnToMenu(ActionEvent event) throws Exception{
    Main.loadMainMenu();
  }

}
