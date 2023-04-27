package edu.bsu.cs222;
import edu.bsu.cs222.english.dictionary.WordSearch;
import edu.bsu.cs222.main.CLI.ErrorHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class WordSearchTests {
    @Test
    public void wordSearchGivesWordSearchedInResultArrayTest() throws IOException {
        Assertions.assertFalse(new WordSearch("grateful").getSearchedWordInformation()[0].isEmpty());
    }
    @Test
    public void wordSearchGivesDefinitionOfWordTest() throws IOException {
        Assertions.assertFalse(new WordSearch("grateful").getSearchedWordInformation()[1].isEmpty());
    }
    @Test
    public void wordSearchGivesSynonymsOfWordTest() throws IOException {
        Assertions.assertFalse(new WordSearch("grateful").getSearchedWordInformation()[2].isEmpty());
    }
    @Test
    public void apiConnectionReturnsTrueWhenConnectedTest(){
        Assertions.assertTrue(ErrorHandler.isNetworkConnected());
    }
    @Test
    public void noErrorIsFoundForValidWordTest(){
        Assertions.assertFalse(ErrorHandler.checkForWordNotFoundError("happy"));
    }
}
