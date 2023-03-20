import edu.bsu.cs222.WordSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class WordSearchTests {
    @Test
    public void wordSearchGivesWordSearchedInResultArrayTest() throws IOException {
        boolean result = new WordSearch("grateful").getSearchedWordInformation()[0].isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void wordSearchGivesDefinitionOfWordTest() throws IOException {
        boolean result = new WordSearch("grateful").getSearchedWordInformation()[1].isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void wordSearchGivesSynonymsOfWordTest() throws IOException {
        boolean result = new WordSearch("grateful").getSearchedWordInformation()[2].isEmpty();
        Assertions.assertFalse(result);
    }
}
