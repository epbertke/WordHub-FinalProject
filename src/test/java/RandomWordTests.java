import edu.bsu.cs222.RandomWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class RandomWordTests {
    @Test
    public void randomWordGeneratesRandomWordTest() throws IOException {
        String[] randomWordOutputArray = new RandomWord().getRandomWordInformation();
        boolean result = randomWordOutputArray[0].isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void randomWordGeneratesRandomWordDefinitionTest() throws IOException {
        String[] randomWordOutputArray = new RandomWord().getRandomWordInformation();
        boolean result = randomWordOutputArray[1].isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void randomWordGeneratesRandomWordSynonymsTest() throws IOException {
        String[] randomWordOutputArray = new RandomWord().getRandomWordInformation();
        boolean result = randomWordOutputArray[2].isBlank();
        Assertions.assertFalse(result);
    }
}
