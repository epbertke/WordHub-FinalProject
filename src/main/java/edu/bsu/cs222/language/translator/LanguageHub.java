package edu.bsu.cs222.language.translator;
import edu.bsu.cs222.english.dictionary.DefinitionParser;
import edu.bsu.cs222.language.translator.translators.chinese.translators.*;
import edu.bsu.cs222.language.translator.translators.english.translators.*;
import edu.bsu.cs222.language.translator.translators.french.translators.*;
import edu.bsu.cs222.language.translator.translators.german.translators.*;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.*;
import edu.bsu.cs222.language.translator.translators.spanish.translators.*;
import java.io.IOException;
public class LanguageHub {
    private final String sourceLanguage;
    private final String wordToTranslate;
    private final String targetLanguage;
    private String translationOutput;
    public LanguageHub(String source, String target, String wordSearch) {
        this.sourceLanguage = source;
        this.wordToTranslate = wordSearch;
        this.targetLanguage = target;
    }
    protected String englishWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "c" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new EnglishToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "g" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new EnglishToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "p" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new EnglishToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "f" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new EnglishToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "s" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new EnglishToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String spanishWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "c" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new SpanishToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "g" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new SpanishToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "p" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new SpanishToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "f" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new SpanishToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "e" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new SpanishToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String germanWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "c" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new GermanToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "s" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new GermanToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "p" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new GermanToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "f" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new GermanToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "e" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new GermanToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String chineseWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "s" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new ChineseToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "g" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new ChineseToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "p" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new ChineseToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "f" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new ChineseToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "e" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new ChineseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String portugueseWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "c" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new PortugueseToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "g" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new PortugueseToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "s" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new PortugueseToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "f" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new PortugueseToFrenchTranslator(wordToTranslate).getTranslatedWordInFrench(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "e" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new PortugueseToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String frenchWordTranslation() throws IOException, InterruptedException {
        switch (targetLanguage) {
            case "c" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new FrenchToChineseTranslator(wordToTranslate).getTranslatedWordInChinese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "g" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new FrenchToGermanTranslator(wordToTranslate).getTranslatedWordInGerman(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "p" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new FrenchToPortugueseTranslator(wordToTranslate).getTranslatedWordInPortuguese(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "s" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new FrenchToSpanishTranslator(wordToTranslate).getTranslatedWordInSpanish(), fetchDefinitionForTranslatedWord()).formatOutput();
            case "e" -> translationOutput = new LanguageOutputFormatter(wordToTranslate, new FrenchToEnglishTranslator(wordToTranslate).getTranslatedWordInEnglish(), fetchDefinitionForTranslatedWord()).formatOutput();
        } return translationOutput;
    }
    protected String fetchDefinitionForTranslatedWord() throws IOException, InterruptedException {
        if(sourceLanguage.equals("e")) {
            return new DefinitionParser(wordToTranslate).parseForDefinition();
        } return new TranslationProcessor(sourceLanguage, wordToTranslate).findDefinitionForWord();
    }
}
