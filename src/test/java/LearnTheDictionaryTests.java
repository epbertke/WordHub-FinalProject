import edu.bsu.cs222.APIConnection;
import edu.bsu.cs222.DefinitionParser;
import edu.bsu.cs222.LearnTheDictionary;
import edu.bsu.cs222.RandomWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LearnTheDictionaryTests {
    @Test
    public void apiConnectionCorrectlyFormatsURLTest() throws IOException {
        APIConnection connection = new APIConnection("watermelon");
        Assertions.assertEquals("https://www.dictionaryapi.com/api/v3/references/collegiate/json/watermelon?key=df32fa24-ccf9-45de-86df-33495904b479", connection.getDefinitionQuery());
    }
    @Test
    public void definitionParserGivesDefinitionTest() throws IOException {
        DefinitionParser parser = new DefinitionParser(new APIConnection("happy").getDefinitionsInputStream());
        Assertions.assertEquals("[\"favored by luck or fortune : fortunate\",\"notably fitting, effective, or well adapted : felicitous\",\"enjoying or characterized by well-being and contentment\"]", parser.fetchDefinition());
    }
    @Test
    public void randomWordGeneratesRandomWordTest() throws IOException {
        String word = new RandomWord().getRandomWord();
        boolean result = !word.isEmpty();
        Assertions.assertTrue(result);
    }
    @Test
    public void randomWordGeneratesRandomWordDefinitionTest() throws IOException {
        String definition = new RandomWord().getRandomWordDefinition();
        boolean result = !definition.isEmpty();
        Assertions.assertTrue(result);
    }
    @Test
    public void learnTheDictionaryFormsOutputForWordSearch() throws IOException {
        LearnTheDictionary dictionary = new LearnTheDictionary("happy");
        Assertions.assertEquals("Your word : happy"+"\n"+"Your definition : [\"favored by luck or fortune : fortunate\",\"notably fitting, effective, or well adapted : felicitous\",\"enjoying or characterized by well-being and contentment\"]", dictionary.getOutputForUser());
    }
    @Test
    public void learnTheDictionaryFormsOutputForRandomWord() throws IOException {
        LearnTheDictionary dictionary = new LearnTheDictionary(new RandomWord().getRandomWord());
        boolean result = !dictionary.getOutputForUser().isEmpty();
        Assertions.assertTrue(result);
    }
}
