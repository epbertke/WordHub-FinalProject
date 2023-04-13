package edu.bsu.cs222;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
public class LearnTheDictionary {
    protected static void start() throws IOException{
        printWelcomeMenu();
        fetchOutputForUser();
    }
    private static void printWelcomeMenu() {
        System.out.println("-".repeat(24)+"\n"+ "Learn The Dictionary"+"\n"+"-".repeat(24));
        System.out.println("""
                To translate a word - Press T
                
                If you would like to learn a random word - Press R
                If you would like to search a specific word; Enter the word
                    """);
    }
    protected static void fetchOutputForUser() throws IOException {
        try{
            if(!ErrorHandler.isNetworkConnected()){
                ErrorHandler.isNetworkConnected();
            }
            String userInput = getUserInput().toLowerCase().strip();
            if(Objects.equals(userInput, "t")){
                LearnTheLanguage.start();
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
