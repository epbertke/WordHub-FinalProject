import edu.bsu.cs222.EnglishToSpanishTranslator;
import edu.bsu.cs222.SpanishToEnglishTranslator;
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

}
