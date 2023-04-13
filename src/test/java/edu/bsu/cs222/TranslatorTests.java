package edu.bsu.cs222;

import edu.bsu.cs222.translators.EnglishToFrenchTranslator;
import edu.bsu.cs222.translators.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class TranslatorTests {
    @Test
    public void englishToSpanishTranslatorGivesWordInSpanish() throws IOException, InterruptedException {
        EnglishToSpanishTranslator translator = new EnglishToSpanishTranslator("apple");
        Assertions.assertEquals("manzana", translator.getTranslatedWordInSpanish());
    }
    @Test
    public void spanishToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException {
        SpanishToEnglishTranslator translator = new SpanishToEnglishTranslator("manzana");
        Assertions.assertEquals("apple", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void invalidWordSearchGivesErrorTestEnglishToSpanish() throws IOException, InterruptedException {
        Assertions.assertEquals("This word was not found in the dictionary. Re-run program and try again with a new word or different spelling.", new EnglishToSpanishTranslator("dlkfaoec").getTranslatedWordInSpanish());
    }
    @Test
    public void englishToGermanTranslatorGivesWordInGerman() throws IOException, InterruptedException{
        EnglishToGermanTranslator translator = new EnglishToGermanTranslator("banana");
        Assertions.assertEquals("banane", translator.getTranslatedWordInGerman());
    }
    @Test
    public void germanToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException{
        GermanToEnglishTranslator translator = new GermanToEnglishTranslator("banane");
        Assertions.assertEquals("banana", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void englishToFrenchTranslatorGivesWordInFrench() throws IOException, InterruptedException{
        EnglishToFrenchTranslator translator = new EnglishToFrenchTranslator("car");
        Assertions.assertEquals("voiture", translator.getTranslatedWordInFrench());

    }
    @Test
    public void frenchToEnglishTranslatorGivesWordInEnglish() throws IOException, InterruptedException{
        FrenchToEnglishTranslator translator = new FrenchToEnglishTranslator("voiture");
        Assertions.assertEquals("car", translator.getTranslatedWordInEnglish());
    }
    @Test
    public void englishToPortugueseTranslatorGivesWordInPortuguese() throws IOException, InterruptedException {
        EnglishToPortugueseTranslator translator = new EnglishToPortugueseTranslator("tomato");
        Assertions.assertEquals("tomate", translator.getTranslatedWordInPortuguese());
    }
    @Test
    public void portugueseToEnglishTranslatorGivesWordInPortuguese() throws IOException, InterruptedException {
        PortugueseToEnglishTranslator translator = new PortugueseToEnglishTranslator("tomate");
        Assertions.assertEquals("tomato", translator.getTranslatedWordInEnglish());
    }



}
