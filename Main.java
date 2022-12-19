package com.example.worddictionary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root;
    @Override
    public void start(Stage primaryStage) throws IOException {
        root = new Group();
        primaryStage.setTitle("Word Dictionary");
        DictionaryPage page = new DictionaryPage();
        root.getChildren().add(page.getRoot());
        primaryStage.setScene(new Scene(root,500,500));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}