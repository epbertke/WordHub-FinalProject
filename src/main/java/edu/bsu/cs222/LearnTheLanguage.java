package edu.bsu.cs222;
import java.io.IOException;
import java.util.Scanner;

public class LearnTheLanguage {
    private static String sourceLanguage;
    private static String targetLanguage;
    private static String wordToTranslate;
    public LearnTheLanguage() {}
    protected static void start() throws IOException, InterruptedException {
        requestSourceLanguage();
        requestTargetLanguage();
        getUserWordToTranslate();
        ErrorHandler.checkForValidRequests(sourceLanguage, targetLanguage);
        new TranslationProcessor(sourceLanguage, targetLanguage, wordToTranslate).processUserRequest();
    }
    protected static void requestSourceLanguage() {
        System.out.println("""
                What language would you like to be your source language (translate from) ?
                
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        Scanner sourceLanguageScanner = new Scanner(System.in);
        sourceLanguage = sourceLanguageScanner.next().toLowerCase();
    }
    protected static void requestTargetLanguage() {
        System.out.println("""
                What language would you like to be your target language (translate to) ?
                
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        Scanner targetLanguageScanner = new Scanner(System.in);
        targetLanguage = targetLanguageScanner.next().toLowerCase();
    }
    protected static void getUserWordToTranslate(){
        System.out.println("Enter the word you would like to translate : ");
        Scanner wordToTranslateScanner = new Scanner(System.in);
        wordToTranslate = wordToTranslateScanner.next().toLowerCase();
    }
}
