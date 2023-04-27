package edu.bsu.cs222.GUI;

import edu.bsu.cs222.main.CLI.LearnTheLanguage;

import java.io.IOException;
import java.util.Objects;

public class ErrorHandler {
    public static boolean checkForValidRequests(String sourceLanguage, String targetLanguage) throws IOException, InterruptedException {
        String[] languageList = {"e", "s", "g", "c", "f", "p"};
        boolean validSource = false;
        boolean validTarget = false;
        for(String language : languageList){
            if(Objects.equals(sourceLanguage, language)){
                validSource = true;
            }if(Objects.equals(targetLanguage, language)){
                validTarget=true;
            }
        }
        if(!validTarget||!validSource){
            System.err.println("This is not a valid translation request.");
            LearnTheLanguage.startForCLI();
            return false;
        }
        return true;
    }
    protected static void throwSearchNotProvidedError(){
        throw new Error("No search was provided.");
    }
}
