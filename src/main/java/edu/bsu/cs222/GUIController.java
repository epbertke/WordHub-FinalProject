package edu.bsu.cs222;
import edu.bsu.cs222.english.dictionary.RandomWord;
import edu.bsu.cs222.english.dictionary.WordSearch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GUIController {
    @FXML
    private TextField searchField;
    @FXML
    private TextArea ltdOutputArea;
    @FXML
    private TextField translationSearch;
    @FXML
    private TextArea ltlOutputArea;
    @FXML
    private Button englishTarget;
    @FXML
    private Button spanishTarget;
    @FXML
    private Button frenchTarget;
    @FXML
    private Button germanTarget;
    @FXML
    private Button portugueseTarget;
    @FXML
    private Button chineseTarget;
    @FXML
    private Button englishSource;
    @FXML
    private Button spanishSource;
    @FXML
    private Button frenchSource;
    @FXML
    private Button germanSource;
    @FXML
    private Button portugueseSearch;
    @FXML
    private Button chineseSearch;
    @FXML
    private Button translateButton;
    @FXML
    private void getWordSearchInputIfProvided(){
        if(searchField.getText().isBlank()){
            ErrorHandler.throwSearchNotProvidedError();
        }else{
            GUIStarter.wordSearch = searchField.getText().strip().toLowerCase();
        }
    }
    @FXML
    private void getTranslatorInputIfProvided(){
        if(translationSearch.getText().isBlank()){
            ErrorHandler.throwSearchNotProvidedError();
        }else{
            GUIStarter.translationSearch = translationSearch.getText().toLowerCase();
        }
    }
    @FXML
    private void displayWordSearchOutput() throws IOException {
        ltdOutputArea.setText(" ");
        try{
            getWordSearchInputIfProvided();
            ltdOutputArea.appendText(new OutputFormatter(new WordSearch(GUIStarter.wordSearch).getSearchedWordInformation()).formOutput());
        }catch(Error e){
            ltdOutputArea.appendText(e.getMessage());
        }
    }
    @FXML
    private void displayRandomWordOutput() throws IOException {
        ltdOutputArea.setText(" ");
        ltdOutputArea.appendText(new OutputFormatter(new RandomWord().getRandomWordInformation()).formOutput());
    }


}