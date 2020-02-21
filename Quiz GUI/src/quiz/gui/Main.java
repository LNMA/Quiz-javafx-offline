package quiz.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import quiz.data.MyData;

public class Main extends Application {
    static Stage stage = new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Quiz System");
        stage.setScene(new Scene(root, 800, 400));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
