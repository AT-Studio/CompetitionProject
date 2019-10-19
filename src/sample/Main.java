package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


}