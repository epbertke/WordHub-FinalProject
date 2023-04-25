package edu.bsu.cs222.GUI;
import edu.bsu.cs222.ErrorHandler;
import edu.bsu.cs222.english.dictionary.RandomWord;
import edu.bsu.cs222.english.dictionary.WordSearch;
import edu.bsu.cs222.language.translator.TranslationProcessor;
import edu.bsu.cs222.main.CLI.OutputFormatter;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
public class GUIController extends GUIStarter{
    private final static TextField searchField = GUIStarter.wordSearchInputField;
    private final static TextArea ltdOutputArea = GUIStarter.lTDOutputArea;
    private final static TextArea ltlOutputArea = GUIStarter.lTLOutputArea;

    protected static void checkIfSearchIsProvided(){
        if(searchField.getText().isBlank()){
            ErrorHandler.throwSearchNotProvidedError();
        }
    }
    protected static void displayWordSearchOutput() throws IOException {
        ltdOutputArea.setText("");
        try{
            checkIfSearchIsProvided();
            ltdOutputArea.appendText(new OutputFormatter(new WordSearch(wordSearchInputField.getText()).getSearchedWordInformation()).formOutput());
        }catch(Error e){
            ltdOutputArea.appendText(e.getMessage());
        }
    }
    protected static void displayRandomWordOutput() throws IOException {
        ltdOutputArea.setText("");
        ltdOutputArea.appendText(new OutputFormatter(new RandomWord().getRandomWordInformation()).formOutput());
    }
    protected static void displayTranslationOutput() throws IOException, InterruptedException {
        try{
            checkIfTranslationSearchIsProvided();
            ltlOutputArea.appendText(new TranslationProcessor(GUIInterpreter.setSourceLanguageKey(sourceLanguageSelector.getValue()), GUIInterpreter.setTargetLanguageKey(targetLanguageSelector.getValue()), translateInputField.getText().strip().toLowerCase()).processUserRequest());
        }catch (Error e){
            ltlOutputArea.appendText(e.getMessage());
        }
    }
    protected static void checkIfTranslationSearchIsProvided(){
        if(sourceLanguageSelector.getValue().isBlank()||targetLanguageSelector.getValue().isBlank()||translateInputField.getText().isBlank()) {
            ErrorHandler.throwSearchNotProvidedError();
        }
    }

    protected static void clearLTDText(){
        ltdOutputArea.clear();
    }
    protected static void clearLTLText(){
        ltlOutputArea.clear();
    }

}
