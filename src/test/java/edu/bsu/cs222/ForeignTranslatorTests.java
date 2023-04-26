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
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToChineseTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToFrenchTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToGermanTranslator;
import edu.bsu.cs222.language.translator.translators.portuguese.translators.PortugueseToSpanishTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToChineseTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToFrenchTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToGermanTranslator;
import edu.bsu.cs222.language.translator.translators.spanish.translators.SpanishToPortugueseTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class ForeignTranslatorTests {
    @Test
    public void chineseToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException {
        Assertions.assertEquals("temps", new ChineseToFrenchTranslator("").getTranslatedWordInFrench());
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
    public void portugueseToSpanishTranslatorGivesWordInSpanishTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tiempo", new PortugueseToSpanishTranslator("tempo").getTranslatedWordInSpanish());
    }
    @Test
    public void portugueseToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("时间", new PortugueseToChineseTranslator("tempo").getTranslatedWordInChinese());
    }
    @Test
    public void portugueseToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException {
        Assertions.assertEquals("temps", new PortugueseToFrenchTranslator("tempo").getTranslatedWordInFrench());
    }
    @Test
    public void PortugueseToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        Assertions.assertEquals("zeit", new PortugueseToGermanTranslator("tempo").getTranslatedWordInGerman());
    }
    @Test
    public void spanishToPortugueseTranslatorGivesWordInPortugueseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("tempo", new SpanishToPortugueseTranslator("tiempo").getTranslatedWordInPortuguese());
    }
    @Test
    public void spanishToChineseTranslatorGivesWordInChineseTest() throws IOException, InterruptedException {
        Assertions.assertEquals("时间", new SpanishToChineseTranslator("tiempo").getTranslatedWordInChinese());
    }
    @Test
    public void spanishToFrenchTranslatorGivesWordInFrenchTest() throws IOException, InterruptedException {
        Assertions.assertEquals("temps", new SpanishToFrenchTranslator("tiempo").getTranslatedWordInFrench());
    }
    @Test
    public void spanishToGermanTranslatorGivesWordInGermanTest() throws IOException, InterruptedException {
        Assertions.assertEquals("zeit", new SpanishToGermanTranslator("tiempo").getTranslatedWordInGerman());
    }
}
