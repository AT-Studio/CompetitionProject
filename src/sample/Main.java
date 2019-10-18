package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Hello World");

        // Load login/signup scene
        Scene loginScene = new Scene(root, 580, 360);
        primaryStage.setScene(loginScene);
        loginScene.getStylesheets()
            .add(Main.class.getResource("loginCSS.css").toExternalForm());
        primaryStage.show();

        // hi in dev

    }


    public static void main(String[] args) {
        launch(args);
    }


}
