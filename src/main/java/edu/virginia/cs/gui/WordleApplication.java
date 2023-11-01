package edu.virginia.cs.gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WordleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WordleApplication.class.getResource("wordle-view.fxml"));
        WordleController con = new WordleController();
        fxmlLoader.setController(con);
        Scene scene = new Scene(fxmlLoader.load(), 400, 700);
        stage.setTitle("Wordle");
        stage.setScene(scene);
        stage.show();
    }
}