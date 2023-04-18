package edu.bsu.cs222;

import edu.bsu.cs222.language.translator.TranslationProcessor;

import java.io.IOException;
import static edu.bsu.cs222.ErrorHandler.checkForValidRequests;

public class LearnTheLanguage {
    private static String sourceLanguage;
    private static String targetLanguage;
    private static String wordToTranslate;
    public LearnTheLanguage(String userSourceLanguage, String userTargetLanguage, String userWordToTranslate){
        sourceLanguage = userSourceLanguage;
        targetLanguage = userTargetLanguage;
        wordToTranslate = userWordToTranslate;
    }
    protected static void startForCLI() throws IOException, InterruptedException {
        sourceLanguage = CLIMenu.requestSourceLanguage();
        targetLanguage = CLIMenu.requestTargetLanguage();
        wordToTranslate = CLIMenu.getUserWordToTranslate();
        checkForValidRequests(sourceLanguage, targetLanguage);
        System.out.println(new TranslationProcessor(sourceLanguage, targetLanguage, wordToTranslate).processUserRequest());
    }
}
