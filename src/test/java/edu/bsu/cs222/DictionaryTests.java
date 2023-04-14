package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class DictionaryTests {
    @Test
    public void randomWordGeneratesRandomWordTest() throws IOException {
        Assertions.assertFalse(new RandomWord().generateRandomWord().isEmpty());
    }
    @Test
    public void dictionaryFileIsProcessedTest() throws IOException {
        Assertions.assertFalse(Dictionary.getWordsInDictionary().isEmpty());
    }
}
