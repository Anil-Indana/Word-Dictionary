package com.example.worddictionary;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DictionaryPage {
    private AnchorPane root;
    DictionaryPage() throws IOException{
        setRoot(FXMLLoader.load(getClass().getResource("DictionaryPage.fxml")));
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    }
}
