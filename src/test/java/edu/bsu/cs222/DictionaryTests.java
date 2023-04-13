package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class DictionaryTests {
    @Test
    public void randomWordGeneratesRandomWordTest() throws IOException {
        String randomWord = new RandomWord().generateRandomWord();
        Assertions.assertFalse(randomWord.isEmpty());
    }
}
