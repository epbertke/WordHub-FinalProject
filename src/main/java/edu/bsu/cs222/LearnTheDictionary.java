package edu.bsu.cs222;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class LearnTheDictionary {
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    protected static String fetchOutputForUser() throws IOException {
        String[] arrayForOutput;
        try{
            String userInput = getUserInput().toLowerCase();
            if(Objects.equals(userInput, "r")){
                arrayForOutput = new RandomWord().getRandomWordInformation();
            }else{
                arrayForOutput = new WordSearch(userInput).getSearchedWordInformation();
            }
        }catch(Error e){
            return "\n"+e.getMessage();
        }
        return new OutputFormatter(arrayForOutput).formOutput();
    }
}
