package edu.bsu.cs222;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.english.translators.*;
import edu.bsu.cs222.language.translator.translators.french.translators.FrenchToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToEnglishTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class EnglishTranslatorTests {
    @Test
    public void invalidWordSearchGivesErrorTest() throws IOException, InterruptedException {
        Assertions.assertEquals("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.", new EnglishToSpanishTranslator("dlkfaoec").getTranslatedWordInSpanish());
    }
    @Test
    public void englishToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        EnglishToSpanishTranslator translator = new EnglishToSpanishTranslator("blue");
        Assertions.assertEquals("azul", translator.getTranslatedWordInSpanish());
    }
    @Test
    public void spanishToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException {
        SpanishToEnglishTranslator translator = new SpanishToEnglishTranslator("hola");
        Assertions.assertEquals("hello", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void englishToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException{
        EnglishToGermanTranslator translator = new EnglishToGermanTranslator("car");
        Assertions.assertEquals("auto", translator.getTranslatedWordInGerman());
    }
    @Test
    public void germanToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        GermanToEnglishTranslator translator = new GermanToEnglishTranslator("kurz");
        Assertions.assertEquals("short", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void englishToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException{
        EnglishToFrenchTranslator translator = new EnglishToFrenchTranslator("car");
        Assertions.assertEquals("voiture", translator.getTranslatedWordInFrench());

    }
    @Test
    public void frenchToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        FrenchToEnglishTranslator translator = new FrenchToEnglishTranslator("Non");
        Assertions.assertEquals("no", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void englishToPortugueseTranslatorGivesWordInPortuguese() throws IOException, InterruptedException {
        EnglishToPortugueseTranslator translator = new EnglishToPortugueseTranslator("blue");
        Assertions.assertEquals("azul", translator.getTranslatedWordInPortuguese());
    }
    @Test
    public void portugueseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        PortugueseToEnglishTranslator translator = new PortugueseToEnglishTranslator("azul");
        Assertions.assertEquals("blue", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void chineseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        ChineseToEnglishTranslator translator = new ChineseToEnglishTranslator("天气");
        Assertions.assertEquals("weather", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void EnglishToChineseTranslatorGivesWordInChinese() throws IOException, InterruptedException {
        EnglishToChineseTranslator translator = new EnglishToChineseTranslator("weather");
        Assertions.assertEquals("天气", translator.getTranslatedWordInChinese());
    }
}
