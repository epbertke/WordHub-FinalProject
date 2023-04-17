package edu.bsu.cs222.language.translator;
import edu.bsu.cs222.english.dictionary.DefinitionParser;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.french.translators.FrenchToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToEnglishTranslator;

import java.io.IOException;
public class LanguageHub {
    private final String sourceLanguage;
    private final String wordToTranslate;
    private String translatedWord;
    public LanguageHub(String source, String wordSearch) {
        this.sourceLanguage = source;
        this.wordToTranslate = wordSearch;
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
