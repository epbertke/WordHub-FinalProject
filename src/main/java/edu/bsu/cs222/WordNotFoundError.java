package edu.bsu.cs222;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
public class WordNotFoundError {
    public static Error throwWordNotFoundError(){
        throw new Error("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.");
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
    public static String checkForWordNotFoundError(String wordSearch) throws IOException{
        String definition;
        try{
            definition = new DefinitionParser(new APIConnection(wordSearch).getDefinitionsInputStream()).parseForDefinition();
        }catch(Error e){
            return e.getMessage();
        }return definition;
    }
}
