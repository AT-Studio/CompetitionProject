package sample;

import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {
  private static Stage stage;
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

  public static Scene getCurrentScene(){
    return currentScene;
  }

  public static void setCurrentScene(Scene scene){
    Main.currentScene = scene;
  }

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
  protected static void loadNewView( String fxml) {
    try {

      Parent root = FXMLLoader.load(Main.class.getResource(fxml));
      Main.setCurrentScene(new Scene(root, 600, 400));

      Main.getStage().setScene(Main.getCurrentScene());

      Main.getStage().show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected static void addTournColumns(TableView tournTable) {
    TableColumn<String, Tournament> tournNameColumn = new TableColumn<>("Tournament Name");
    tournNameColumn.setCellValueFactory(new PropertyValueFactory<>("tournamentName"));

    TableColumn<Date, Tournament> startDateColumn = new TableColumn<>("Start Date");
    startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

    TableColumn<String, Tournament> startTimeColumn = new TableColumn<>("Start Time");
    tournNameColumn.setCellValueFactory(new PropertyValueFactory<>("startTime"));

    tournTable.getColumns().add(tournNameColumn);
    tournTable.getColumns().add(startDateColumn);
    tournTable.getColumns().add(startTimeColumn);
  }
}