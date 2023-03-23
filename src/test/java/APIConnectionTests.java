import edu.bsu.cs222.APIConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
public class APIConnectionTests {
    @Test
    public void apiConnectionCorrectlyFormatsDefinitionsURLTest() throws IOException {
        APIConnection connection = new APIConnection("watermelon");
        Assertions.assertEquals("https://www.dictionaryapi.com/api/v3/references/collegiate/json/watermelon?key=df32fa24-ccf9-45de-86df-33495904b479", connection.getDefinitionQuery());
    }
    @Test
    public void apiConnectionCorrectlyFormatsSynonymsURLTest() throws IOException {
        APIConnection connection = new APIConnection("watermelon");
        Assertions.assertEquals("https://www.dictionaryapi.com/api/v3/references/thesaurus/json/watermelon?key=2c139559-35fb-4943-9ab6-5ffbf25d3bf8", connection.getSynonymQuery());
    }
    @Test
    public void apiConnectionOpensDefinitionInputStreamTest() throws IOException {
        Assertions.assertFalse(new APIConnection("watermelon").getDefinitionsInputStream().toString().isEmpty());
    }
    @Test
    public void apiConnectionOpensSynonymsInputStreamTest() throws IOException {
        boolean result  = new APIConnection("watermelon").getSynonymsInputStream().toString().isEmpty();
        Assertions.assertFalse(result);
    }
}
