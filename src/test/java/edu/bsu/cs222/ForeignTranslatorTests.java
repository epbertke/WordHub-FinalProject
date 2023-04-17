package edu.bsu.cs222;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToFrenchTranslator;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToGermanTranslator;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToPortugueseTranslator;
import edu.bsu.cs222.language.translator.translators.chinese.translators.ChineseToSpanishTranslator;
import edu.bsu.cs222.language.translator.translators.french.translators.*;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToChineseTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToFrenchTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToPortugueseTranslator;
import edu.bsu.cs222.language.translator.translators.german.translators.GermanToSpanishTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class ForeignTranslatorTests {
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
}
