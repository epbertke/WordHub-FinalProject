package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;

public class LearnTheLanguage {
    private String sourceLanguage;
    private String targetLanguage;
    private String wordToTranslate;
    public LearnTheLanguage() {}
    protected String openTranslationApplication() throws IOException, InterruptedException {
        System.out.println("What language would you like to be your source language (translate from) ?"+"\n"+
                "Spanish - enter S"+"\n"+
                "English - enter E");
        getUserSourceLanguage();
        System.out.println("What language would you like to be your target language (translate to) ?"+"\n"+
                "Spanish - enter S"+"\n"+
                "English - enter E");
        getUserTargetLanguage();
        System.out.println("Enter the word you would like to translate :");
        getUserWordToTranslate();
        return "Original : "+wordToTranslate.toLowerCase()+"\n"+"Translation : "+processUserRequest();
    }
    private void getUserSourceLanguage(){
        Scanner sourceLanguageScanner = new Scanner(System.in);
        sourceLanguage = sourceLanguageScanner.next().toLowerCase();
    }
    private void getUserTargetLanguage(){
        Scanner targetLanguageScanner = new Scanner(System.in);
        targetLanguage  = targetLanguageScanner.next().toLowerCase();
    }
    private void getUserWordToTranslate(){
        Scanner wordToTranslateScanner = new Scanner(System.in);
        wordToTranslate = wordToTranslateScanner.next().toLowerCase();
    }
    private String processUserRequest() throws IOException, InterruptedException {
        String translation = null;
        if(sourceLanguage.equals("s")&&targetLanguage.equals("e")){
            translation = new SpanishToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
        }else if(sourceLanguage.equalsIgnoreCase("e")&&targetLanguage.equalsIgnoreCase("s")){
            translation = new EnglishToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish();
        }return translation;
    }
}
