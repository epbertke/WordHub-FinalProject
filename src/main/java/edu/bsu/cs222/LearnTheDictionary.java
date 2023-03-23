package edu.bsu.cs222;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class LearnTheDictionary {
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    protected static String fetchOutputForUser() throws IOException, InterruptedException {
        String[] arrayForOutput;
        try{
            if(!WordNotFoundError.isNetworkConnected()){
                WordNotFoundError.isNetworkConnected();
            }
            String userInput = getUserInput().toLowerCase();
            if(Objects.equals(userInput, "r")){
                arrayForOutput = new RandomWord().getRandomWordInformation();
            }else if(Objects.equals(userInput, "t")){
                return new LearnTheLanguage().openTranslationApplication();
            }else{
                arrayForOutput = new WordSearch(userInput).getSearchedWordInformation();
            }
        }catch(Error e){
            return "\n"+e.getMessage()+"\n";
        }
        return new OutputFormatter(arrayForOutput).formOutput();
    }
}
