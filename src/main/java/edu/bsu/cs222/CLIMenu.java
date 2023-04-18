package edu.bsu.cs222;
import java.util.Scanner;
public class CLIMenu {
    protected static void printExitStatement() {
        System.out.println("\n" + "-".repeat(40) + "\n" + "Re-run program to learn another word" + "\n" + "-".repeat(40) + "\n");
    }
    public static void printWelcomeMenu() {
        System.out.println("-".repeat(24)+"\n"+ "Learn The Dictionary"+"\n"+"-".repeat(24));
        System.out.println("""
                To translate a word - Press T
                
                If you would like to learn a random word - Press R
                If you would like to search a specific word; Enter the word
                    """);
    }
    protected static String requestSourceLanguage() {
        System.out.println("""
                What language would you like to be your source language (translate from) ?
                
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        Scanner sourceLanguageScanner = new Scanner(System.in);
        return sourceLanguageScanner.next().toLowerCase();
    }
    protected static String requestTargetLanguage() {
        System.out.println("""
                What language would you like to be your target language (translate to) ?
                
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        Scanner targetLanguageScanner = new Scanner(System.in);
        return targetLanguageScanner.next().toLowerCase();
    }
    protected static String getUserWordToTranslate(){
        System.out.println("Enter the word you would like to translate : ");
        Scanner wordToTranslateScanner = new Scanner(System.in);
        return wordToTranslateScanner.next().toLowerCase();
    }
}
