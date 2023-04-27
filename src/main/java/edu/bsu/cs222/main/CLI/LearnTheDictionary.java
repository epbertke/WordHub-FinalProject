package edu.bsu.cs222.main.CLI;
import edu.bsu.cs222.english.dictionary.RandomWord;
import edu.bsu.cs222.english.dictionary.WordSearch;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class LearnTheDictionary {
    private static String userInput;
    public LearnTheDictionary(String userStartInput){
        userInput = userStartInput;
    }
    public static void startForClI() throws IOException{
        CLIMenu.printWelcomeMenu();
        fetchCLIOutputForUser();
    }

    protected static void fetchCLIOutputForUser() throws IOException {
        try{
            if(!ErrorHandler.isNetworkConnected()){
                ErrorHandler.isNetworkConnected();
            }
            userInput = getUserInput().toLowerCase().strip();
            if(Objects.equals(userInput, "t")){
                LearnTheLanguage.startForCLI();
            }else if(Objects.equals(userInput, "r")){
                System.out.println(new OutputFormatter(new RandomWord().getRandomWordInformation()).formOutput());
            }else{
                System.out.println(new OutputFormatter(new WordSearch(userInput).getSearchedWordInformation()).formOutput());
            }
        }catch(Error e){
            System.out.println("\n"+e.getMessage()+"\n");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
