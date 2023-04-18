package edu.bsu.cs222;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GUIStarter extends Application {
    public static String wordSearch;
    public static String translationSearch;
    public static char sourceLanguage;
    public static char targetLanguage;
    @Override
    public void start(Stage stage) throws IOException {
        try{
            URL url = new File("src/main/resources/ltlgui.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 600, 796);
            stage.setTitle("--- ***WordHub*** ----------------------------------- ***LearnTheLanguage*** ---");
            stage.setScene(scene);
            stage.show();
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) { launch(args); }

}
