package edu.bsu.cs222.main.CLI;
import edu.bsu.cs222.GUI.ErrorHandler;
import edu.bsu.cs222.language.translator.TranslationProcessor;
import java.io.IOException;
public class LearnTheLanguage extends CLIMenu{
    private static String sourceLanguage;
    private static String targetLanguage;
    private static String wordToTranslate;
    public LearnTheLanguage(String userSourceLanguage, String userTargetLanguage, String userWordToTranslate){
        sourceLanguage = userSourceLanguage;
        targetLanguage = userTargetLanguage;
        wordToTranslate = userWordToTranslate;
    }
    public static void startForCLI() throws IOException, InterruptedException {
        sourceLanguage = CLIMenu.requestSourceLanguage();
        targetLanguage = CLIMenu.requestTargetLanguage();
        wordToTranslate = CLIMenu.getUserWordToTranslate();
        ErrorHandler.checkForValidRequests(sourceLanguage, targetLanguage);
        System.out.println(new TranslationProcessor(sourceLanguage, targetLanguage, wordToTranslate).processUserRequest());
    }
}
