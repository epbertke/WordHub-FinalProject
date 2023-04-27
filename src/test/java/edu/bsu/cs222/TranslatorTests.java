package edu.bsu.cs222;
import edu.bsu.cs222.GUI.ErrorHandler;
import edu.bsu.cs222.language.translator.translators.chinese.translators.*;
import edu.bsu.cs222.language.translator.translators.english.translators.*;
import edu.bsu.cs222.language.translator.translators.french.translators.*;
import edu.bsu.cs222.language.translator.translators.german.translators.*;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToEnglishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToEnglishTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class TranslatorTests {
    @Test
    public void invalidWordSearchGivesErrorTest() throws IOException, InterruptedException {
        Assertions.assertEquals("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.", new EnglishToSpanishTranslator("dlkfaoec").getTranslatedWordInSpanish());
    }
    @Test
    public void englishToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("azul", new EnglishToSpanishTranslator("blue").getTranslatedWordInSpanish());
    }
    @Test
    public void spanishToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("hello", new SpanishToEnglishTranslator("hola").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException{
        Assertions.assertEquals("auto", new EnglishToGermanTranslator("car").getTranslatedWordInGerman());
    }
    @Test
    public void germanToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        Assertions.assertEquals("short", new GermanToEnglishTranslator("kurz").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException{
        Assertions.assertEquals("voiture", new EnglishToFrenchTranslator("car").getTranslatedWordInFrench());


    }
    @Test
    public void frenchToEnglishTranslatorGivesWordInEnglishTest() throws IOException, InterruptedException{
        Assertions.assertEquals("no", new FrenchToEnglishTranslator("Non").getTranslatedWordInEnglish());
    }
    @Test
    public void englishToPortugueseTranslatorGivesWordInPortuguese() throws IOException, InterruptedException {
        Assertions.assertEquals("azul", new EnglishToPortugueseTranslator("blue").getTranslatedWordInPortuguese());
    }
    @Test
    public void portugueseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        Assertions.assertEquals("blue", new PortugueseToEnglishTranslator("azul").getTranslatedWordInEnglish());
    }
    @Test
    public void chineseToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        Assertions.assertEquals("weather", new ChineseToEnglishTranslator("天气").getTranslatedWordInEnglish());
    }
    @Test
    public void EnglishToChineseTranslatorGivesWordInChinese() throws IOException, InterruptedException {
        Assertions.assertEquals("天气", new EnglishToChineseTranslator("weather").getTranslatedWordInChinese());
    }
    @Test
    public void chineseToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException {
        Assertions.assertEquals("temps", new ChineseToFrenchTranslator("天气").getTranslatedWordInFrench());
    }
    @Test
    public void chineseToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        Assertions.assertEquals("wetter", new ChineseToGermanTranslator("天气").getTranslatedWordInGerman());
    }
    @Test
    public void chineseToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("clima", new ChineseToSpanishTranslator("天气").getTranslatedWordInSpanish());
    }
    @Test
    public void chineseToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("clima", new ChineseToPortugueseTranslator("天气").getTranslatedWordInPortuguese());
    }
    @Test
    public void frenchToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("时间", new FrenchToChineseTranslator("temps").getTranslatedWordInChinese());
    }
    @Test
    public void frenchToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        Assertions.assertEquals("zeit", new FrenchToGermanTranslator("temps").getTranslatedWordInGerman());
    }
    @Test
    public void frenchToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tiempo", new FrenchToSpanishTranslator("temps").getTranslatedWordInSpanish());
    }
    @Test
    public void frenchToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tempo", new FrenchToPortugueseTranslator("temps").getTranslatedWordInPortuguese());
    }
    @Test
    public void germanToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("时间", new GermanToChineseTranslator("zeit").getTranslatedWordInChinese());
    }
    @Test
    public void germanToFrenchTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        Assertions.assertEquals("temps", new GermanToFrenchTranslator("zeit").getTranslatedWordInFrench());
    }
    @Test
    public void germanToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tiempo", new GermanToSpanishTranslator("zeit").getTranslatedWordInSpanish());
    }
    @Test
    public void germanToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tempo", new GermanToPortugueseTranslator("zeit").getTranslatedWordInPortuguese());
    }
    @Test
    public void errorHandlerReturnsTrueIfLanguagesAreValid() throws IOException, InterruptedException {
        Assertions.assertTrue(ErrorHandler.checkForValidRequests("s", "e"));
    }
}
