package edu.bsu.cs222;
import edu.bsu.cs222.translators.*;
import java.io.IOException;

public class TranslationProcessor {
    private final String sourceLanguage;
    private final String targetLanguage;
    private final String wordToTranslate;
    public TranslationProcessor(String source, String target, String wordSearch) {
        this.sourceLanguage = source;
        this.targetLanguage = target;
        this.wordToTranslate = wordSearch;
    }
    protected void processUserRequest() throws IOException, InterruptedException {
        if (sourceLanguage.equals("s") && targetLanguage.equals("e")) {
            new LanguageOutputFormatter(wordToTranslate, new SpanishToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("s")) {
            new LanguageOutputFormatter(wordToTranslate, new EnglishToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("g") && targetLanguage.equals("e")) {
            new LanguageOutputFormatter(wordToTranslate, new GermanToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("g")) {
            new LanguageOutputFormatter(wordToTranslate, new EnglishToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("f") && targetLanguage.equals("e")) {
            new LanguageOutputFormatter(wordToTranslate, new FrenchToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equalsIgnoreCase("e") && targetLanguage.equalsIgnoreCase("f")) {
            new LanguageOutputFormatter(wordToTranslate, new EnglishToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("c") && targetLanguage.equals("e")) {
            new LanguageOutputFormatter(wordToTranslate, new ChineseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("e") && targetLanguage.equalsIgnoreCase("c")) {
            new LanguageOutputFormatter(wordToTranslate, new EnglishToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("p") && targetLanguage.equals("e")) {
            new LanguageOutputFormatter(wordToTranslate, new PortugueseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } else if (sourceLanguage.equals("e") && targetLanguage.equals("p")) {
            new LanguageOutputFormatter(wordToTranslate, new EnglishToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
        }
    }
    private String fetchDefinitionForTranslatedWord() throws IOException, InterruptedException {
        if(sourceLanguage.equals("e")){
            return new DefinitionParser(wordToTranslate).parseForDefinition();
        }return new LanguageHub(sourceLanguage, wordToTranslate).findDefinitionForWord();
    }
}
