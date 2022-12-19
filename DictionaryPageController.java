package com.example.worddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class DictionaryPageController {
    @FXML
    TextField search;
    @FXML
    TextField meaning;
    @FXML
    TextField newWord;
    @FXML
    TextField word;
    @FXML
    DictionarySaver db;
    public void searchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        try{
            db = new DictionarySaver();
            db.deserializeHashMap();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dictionary");
            if(search.getText().equals("")){
                alert.setContentText("Please Enter a word.");
                alert.showAndWait();
            }
            else if(db.getDictionaryList().containsKey(search.getText().toLowerCase())){
                alert.setContentText("Word is Available.");
                alert.showAndWait();
            }else{
                alert.setContentText("Word is Not Available.");
                alert.showAndWait();
            }
        } catch (IOException e) {
            db.serializeHashMap();
        }

    }
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(newWord.getText().equals("") || meaning.getText().equals("")){
            alert.setContentText("Please enter a word.");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(newWord.getText().toLowerCase())){
            alert.setContentText("Word is already available in dictionary");
            alert.showAndWait();
        }
        else{
            db.getDictionaryList().put(newWord.getText().toLowerCase(),meaning.getText());
            db.serializeHashMap();
            alert.setContentText("New word is added to the Dictionary.");
            alert.showAndWait();
        }
    }
    public void getMeaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(word.getText() .equals("")){
            alert.setContentText("Please enter a word");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(word.getText())) {
            alert.setContentText(db.getDictionaryList().get(word.getText()));
            alert.showAndWait();
        }else{
            alert.setContentText("Word Not Found.");
            alert.showAndWait();
        }
    }
}
