import edu.bsu.cs222.*;
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
        boolean result = new RandomWord().getRandomWord().isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void randomWordGeneratesRandomWordDefinitionTest() throws IOException {
        boolean result = new RandomWord().getRandomWordDefinition().isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void learnTheDictionaryFormsOutputForWordSearchTest() throws IOException {
        LearnTheDictionary dictionary = new LearnTheDictionary("happy");
        Assertions.assertEquals("Your word : happy\n" +
                "Your definition : [\"favored by luck or fortune : fortunate\",\"notably fitting, effective, or well adapted : felicitous\",\"enjoying or characterized by well-being and contentment\"]\n" +
                "Synonyms : [[\"affable\",\"breezy\",\"devil-may-care\",\"easygoing\",\"laid-back\",\"low-pressure\",\"mellow\"],[\"blithe\",\"carefree\",\"debonair\",\"devil-may-care\",\"gay\",\"insouciant\",\"lighthearted\",\"lightsome\",\"slaphappy\",\"unconcerned\"]]", dictionary.getOutputForUser());
    }
    @Test
    public void learnTheDictionaryFormsOutputForRandomWordTest() throws IOException {
        boolean result = new LearnTheDictionary(new RandomWord().getRandomWord()).getOutputForUser().isEmpty();
        Assertions.assertFalse(result);
    }
    @Test
    public void synonymParserGivesSynonymsTest() throws IOException {
        SynonymParser parser = new SynonymParser(new APIConnection("happy").getSynonymsInputStream());
        Assertions.assertEquals("[[\"affable\",\"breezy\",\"devil-may-care\",\"easygoing\",\"laid-back\",\"low-pressure\",\"mellow\"],[\"blithe\",\"carefree\",\"debonair\",\"devil-may-care\",\"gay\",\"insouciant\",\"lighthearted\",\"lightsome\",\"slaphappy\",\"unconcerned\"]]", parser.fetchSynonyms());
    }
}
