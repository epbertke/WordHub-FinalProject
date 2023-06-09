package edu.bsu.cs222.GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.geometry.Pos.*;
public class GUIStarter extends Application {
    public static void main(String[] args) { launch(args); }
    private final Button search = new Button("Search");
    private final Button random = new Button("Random !");
    private final Button translate = new Button("Translate");
    private final Button clearTop = new Button("Clear Top Text");
    private final Button clearBottom = new Button("Clear Bottom Text");
    protected static final TextField wordSearchInputField = new TextField();
    protected static final TextField translateInputField = new TextField();
    protected static final TextArea lTLOutputArea = new TextArea();
    protected static final TextArea lTDOutputArea = new TextArea();
    protected static  final ComboBox<String> sourceLanguageSelector = new ComboBox<>();
    protected static final ComboBox<String> targetLanguageSelector = new ComboBox<>();
    private final Label dictionaryLabel = new Label("Search an English word, or click to learn a random word below :");
    private final Label translationLabel = new Label("To translate a word, type the word and specify your language options below :");
    private final Label targetLabel = new Label("Translate to : ");
    private final Label sourceLabel = new Label("Translate from : ");
    private final String[] supportedLanguages = {"English", "Spanish", "Portuguese", "German", "Chinese", "French"};
    @Override
    public void start(Stage stage) {
        configureOutputFields();
        configureLabels();
        configureComboBoxes();
        configureTranslateButton();
        configureSearchButton();
        configureRandomButton();
        configureTopButton();
        configureBottomButton();
        configure(stage);
    }
    private void configure(Stage stage){
        stage.setTitle("--- ***WordHub*** ---------------------------------- ***LearnTheLanguage*** ---");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private void configureOutputFields(){
        lTDOutputArea.setEditable(false);
        lTLOutputArea.setEditable(false);
        lTDOutputArea.setWrapText(true);
        lTLOutputArea.setWrapText(true);
    }
    private Pane createRoot() {
        VBox root = new VBox();
        root.setPrefSize(600, 700);
        root.getChildren().addAll(dictionaryLabel, configureDictionaryInputField(), createDictionaryButtonHBox(), lTDOutputArea, translationLabel, configureTranslateInputField(), createTranslatorHBox(), lTLOutputArea, createTranslateButtonBox(), createClearButtonBox());
        return root;
    }
    private void configureComboBoxes() {
        sourceLanguageSelector.getItems().addAll(supportedLanguages);
        targetLanguageSelector.getItems().addAll(supportedLanguages);
    }
    private HBox createDictionaryButtonHBox() {
        HBox container = new HBox();
        container.setAlignment(CENTER);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(random, search);
        return container;
    }
    private HBox createTranslatorHBox() {
        HBox container = new HBox();
        container.setAlignment(CENTER);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(targetLabel, targetLanguageSelector, sourceLabel, sourceLanguageSelector);
        return container;
    }
    private HBox configureTranslateInputField(){
        HBox hBox = new HBox();
        translateInputField.setMaxWidth(350);
        hBox.getChildren().add(translateInputField);
        hBox.setAlignment(CENTER);
        return hBox;
    }
    private HBox configureDictionaryInputField(){
        HBox hBox = new HBox();
        wordSearchInputField.setMaxWidth(350);
        hBox.getChildren().add(wordSearchInputField);
        hBox.setAlignment(CENTER);
        return hBox;
    }
    private void configureSearchButton() {
        search.setOnAction(event -> {
            try {
                GUIController.displayWordSearchOutput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void configureRandomButton() {
        random.setOnAction(event -> {
            try {
                GUIController.displayRandomWordOutput();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void configureTranslateButton()  {
        translate.setOnAction(event -> {
            try {
                GUIController.displayTranslationOutput();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void configureLabels(){
        dictionaryLabel.setPadding(new Insets(20, 0, 10, 10));
        translationLabel.setPadding(new Insets(20, 0, 10, 10));
        translationLabel.setFont(Font.font(15));
        dictionaryLabel.setFont(Font.font(15));
        targetLabel.setPadding(new Insets(10));
        sourceLabel.setPadding(new Insets(10));
    }
    private HBox createTranslateButtonBox(){
        HBox container = new HBox();
        container.setAlignment(CENTER);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(translate);
        return container;
    }
    private HBox createClearButtonBox(){
        HBox container = new HBox();
        container.setAlignment(BASELINE_CENTER);
        container.setPadding(new Insets(10));
        container.getChildren().addAll(clearTop, clearBottom);
        return container;
    }
    private void configureTopButton(){
        clearTop.setOnAction(event -> GUIController.clearLTDText());

    }
    private void configureBottomButton(){
        clearBottom.setOnAction(event -> GUIController.clearLTLText());
    }
}
