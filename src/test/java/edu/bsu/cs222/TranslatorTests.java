package edu.bsu.cs222;
import edu.bsu.cs222.GUI.ErrorHandler;
import edu.bsu.cs222.language.translator.translators.chinese.translators.*;
import edu.bsu.cs222.language.translator.translators.english.translators.*;
import edu.bsu.cs222.language.translator.translators.french.translators.*;
import edu.bsu.cs222.language.translator.translators.german.translators.*;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToEnglishTranslator;
import edu.bsu.cs222.main.CLI.LearnTheLanguage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslatorTests {
    @Test
    public void invalidWordSearchGivesErrorTest() throws IOException, InterruptedException {
        assertEquals("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.", new EnglishToSpanishTranslator("dlkfaoec").getTranslatedWordInSpanish());
    }
    @Test
    public void englishToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        assertEquals("azul", new EnglishToSpanishTranslator("blue").getTranslatedWordInSpanish());
    }
    @Test
    public void spanishToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException {
        assertEquals("hello", new SpanishToEnglishTranslator("hola").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException{
        assertEquals("auto", new EnglishToGermanTranslator("car").getTranslatedWordInGerman());
    }
    @Test
    public void germanToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        assertEquals("short", new GermanToEnglishTranslator("kurz").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException{
        assertEquals("voiture", new EnglishToFrenchTranslator("car").getTranslatedWordInFrench());


    }
    @Test
    public void frenchToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        assertEquals("no", new FrenchToEnglishTranslator("Non").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToPortugueseTranslatorGivesWordInPortuguese() throws IOException, InterruptedException {
        assertEquals("azul", new EnglishToPortugueseTranslator("blue").getTranslatedWordInPortuguese());
    }
    @Test
    public void portugueseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        assertEquals("blue", new PortugueseToEnglishTranslator("azul").getTranslatedWordInEnglish());
    }
    @Test
    public void chineseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        assertEquals("weather", new ChineseToEnglishTranslator("天气").getTranslatedWordInEnglish());
    }
    @Test
    public void EnglishToChineseTranslatorGivesWordInChinese() throws IOException, InterruptedException {
        assertEquals("天气", new EnglishToChineseTranslator("weather").getTranslatedWordInChinese());
    }
    @Test
    public void chineseToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException {
        assertEquals("temps", new ChineseToFrenchTranslator("天气").getTranslatedWordInFrench());
    }
    @Test
    public void chineseToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        assertEquals("wetter", new ChineseToGermanTranslator("天气").getTranslatedWordInGerman());
    }
    @Test
    public void chineseToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        assertEquals("clima", new ChineseToSpanishTranslator("天气").getTranslatedWordInSpanish());
    }
    @Test
    public void chineseToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        assertEquals("clima", new ChineseToPortugueseTranslator("天气").getTranslatedWordInPortuguese());
    }
    @Test
    public void frenchToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        assertEquals("时间", new FrenchToChineseTranslator("temps").getTranslatedWordInChinese());
    }
    @Test
    public void frenchToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        assertEquals("zeit", new FrenchToGermanTranslator("temps").getTranslatedWordInGerman());
    }
    @Test
    public void frenchToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        assertEquals("tiempo", new FrenchToSpanishTranslator("temps").getTranslatedWordInSpanish());
    }
    @Test
    public void frenchToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        assertEquals("tempo", new FrenchToPortugueseTranslator("temps").getTranslatedWordInPortuguese());
    }
    @Test
    public void germanToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        assertEquals("时间", new GermanToChineseTranslator("zeit").getTranslatedWordInChinese());
    }
    @Test
    public void germanToFrenchTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        assertEquals("temps", new GermanToFrenchTranslator("zeit").getTranslatedWordInFrench());
    }
    @Test
    public void germanToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        assertEquals("tiempo", new GermanToSpanishTranslator("zeit").getTranslatedWordInSpanish());
    }
    @Test
    public void germanToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        assertEquals("tempo", new GermanToPortugueseTranslator("zeit").getTranslatedWordInPortuguese());
    }
    @Test
    public void errorHandlerReturnsTrueIfLanguagesAreValidTest() throws IOException, InterruptedException {
        Assertions.assertTrue(ErrorHandler.checkForValidRequests("s", "e"));
    }
    @Test
    public void cliStarterReturnsTranslationOutputTest() {
        new LearnTheLanguage("e", "s", "car");
        String output = String.valueOf(System.out);
        Assertions.assertFalse(output.isEmpty());
    }
}
