package edu.bsu.cs222.main.CLI;
import edu.bsu.cs222.english.dictionary.DefinitionParser;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
public class ErrorHandler {
    public static Error throwWordNotFoundError(){
        throw new Error("This word was not found. Re-run program and try again with a new word or different spelling.");
    }

    public static boolean isNetworkConnected() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
            throw new Error("No network connection. Check connection and re-run program to try again.");
        }
    }
    public static boolean checkForWordNotFoundError(String wordSearch) {
        try{
            String definition = new DefinitionParser(wordSearch).parseForDefinition();
            if(!definition.isEmpty()){
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }return true;
    }
}
