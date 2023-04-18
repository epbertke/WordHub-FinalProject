package edu.bsu.cs222.language.translator;
import edu.bsu.cs222.english.dictionary.DefinitionParser;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.french.translators.FrenchToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToEnglishTranslator;
import java.io.IOException;
public class TranslationProcessor {
    private final String sourceLanguage;
    private final String targetLanguage;
    private final String wordToTranslate;
    private String translatedWord;
    private String translationOutputForUser;
    public TranslationProcessor(String source, String target, String wordSearch) {
        this.sourceLanguage = source;
        this.targetLanguage = target;
        this.wordToTranslate = wordSearch;
    }
    public String processUserRequest() throws IOException, InterruptedException {
        switch (sourceLanguage) {
            case "s" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).spanishWordTranslation();
            case "g" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).germanWordTranslation();
            case "e" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).englishWordTranslation();
            case "p" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).portugueseWordTranslation();
            case "c" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).chineseWordTranslation();
            case "f" -> translationOutputForUser = new LanguageHub(sourceLanguage, targetLanguage, wordToTranslate).frenchWordTranslation();
        }
        return translationOutputForUser;
    }
    public TranslationProcessor(String source, String wordSearch) {
        this.sourceLanguage = source;
        this.wordToTranslate = wordSearch;
        this.targetLanguage = null;
    }
    public String findDefinitionForWord() throws IOException, InterruptedException {
        switch (sourceLanguage) {
            case "s" -> translatedWord = new SpanishToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            case "g" -> translatedWord = new GermanToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            case "f" -> translatedWord = new FrenchToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            case "c" -> translatedWord = new ChineseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
            case "p" -> translatedWord = new PortugueseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish();
        }
        return new DefinitionParser(translatedWord).parseForDefinition();
    }
}
