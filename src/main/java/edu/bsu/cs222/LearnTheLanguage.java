package edu.bsu.cs222;

import edu.bsu.cs222.translators.*;

import java.io.IOException;
import java.util.Scanner;

public class LearnTheLanguage {
    private String sourceLanguage;
    private String targetLanguage;
    private String wordToTranslate;
    public LearnTheLanguage() {}
    protected String openTranslationApplication() throws IOException, InterruptedException {
        System.out.println("""
                What language would you like to be your source language (translate from) ?
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        getUserSourceLanguage();
        System.out.println("""
                What language would you like to be your target language (translate to) ?
                Spanish - enter S
                German - enter G
                French - enter F
                Portuguese - enter P
                Chinese - enter C
                English - enter E""");
        getUserTargetLanguage();
        System.out.println("Enter the word you would like to translate :");
        getUserWordToTranslate();
        return "Original : "+wordToTranslate+"\n"+"Translation : "+processUserRequest();
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
    public String processUserRequest() throws IOException, InterruptedException {
        String englishDefinitionOutput = "\n" + "Definition : ";
        String translation = " ";
        String definition = " ";
        if (sourceLanguage.equals("s") && targetLanguage.equals("e")) {
            translation = new SpanishToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            definition = new TranslationProcessor(translation).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput + definition;
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("s")) {
            translation = new EnglishToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        } else if (sourceLanguage.equals("g") && targetLanguage.equals("e")) {
            translation = new GermanToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            definition = new TranslationProcessor(translation).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput + definition;
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("g")) {
            translation = new EnglishToGermanTranslator(wordToTranslate).getTranslatedWordInGerman();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        } else if (sourceLanguage.equals("f") && targetLanguage.equals("e")) {
            translation = new FrenchToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            definition = new TranslationProcessor(translation).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput + definition;
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("f")) {
            translation = new EnglishToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        }else if(sourceLanguage.equals("p") && targetLanguage.equals("e")){
            translation = new PortugueseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        }else if(sourceLanguage.equals("e") && targetLanguage.equals("p")){
            translation = new EnglishToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        }else if(sourceLanguage.equals("c")&&targetLanguage.equals("e")){
            translation = new ChineseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput+definition;
        }else if(sourceLanguage.equals("e")&&targetLanguage.equals("c")) {
            translation = new EnglishToChineseTranslator(wordToTranslate).getTranslatedWordInChinese();
            definition = new TranslationProcessor(wordToTranslate).fetchDefinitionForTranslatedWord();
            definition = englishDefinitionOutput + definition;
        }
        return translation+definition;
    }
}
