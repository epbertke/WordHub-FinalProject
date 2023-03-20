import edu.bsu.cs222.DefinitionParser;
import edu.bsu.cs222.SynonymParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
public class ParserTests {
    @Test
    public void definitionParserGivesDefinitionTest() throws IOException {
        Assertions.assertEquals("[\"a state of well-being and contentment : joy\",\"a pleasurable or satisfying experience\",\"felicity, aptness\"]", new DefinitionParser(new FileInputStream("src/main/resources/sample_data_definition")).parseForDefinition());
    }
    @Test
    public void synonymParserGivesSynonymsTest() throws IOException {
        Assertions.assertEquals("[[\"fluky\",\"fortuitous\",\"fortunate\",\"heaven-sent\",\"lucky\",\"providential\"],[\"blissful\",\"chuffed\",\"delighted\",\"glad\",\"gratified\",\"joyful\",\"joyous\",\"pleased\",\"satisfied\",\"thankful\",\"tickled\"],[\"content\",\"contented\",\"gratified\",\"pleased\",\"satisfied\"],[\"fortunate\",\"lucky\"],[\"applicable\",\"appropriate\",\"apt\",\"becoming\",\"befitting\",\"felicitous\",\"fit\",\"fitted\",\"fitting\",\"good\",\"meet\",\"pretty\",\"proper\",\"right\",\"suitable\"],[\"hung up\",\"obsessed\",\"queer\"]]", new SynonymParser(new FileInputStream("src/main/resources/sample_data_synonyms")).parseForSynonyms());
    }
}
