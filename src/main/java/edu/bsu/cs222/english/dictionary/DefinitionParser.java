package edu.bsu.cs222.english.dictionary;
import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.ErrorHandler;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
public class DefinitionParser {
    private final InputStream definitionsInputStream;
    public DefinitionParser(String wordSearch) throws IOException {
        definitionsInputStream = new APIConnection(wordSearch).getDefinitionsInputStream();
    }
    public String parseForDefinition() throws IOException {
        JSONArray result = JsonPath.parse(definitionsInputStream).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..shortdef");
        definitionsInputStream.close();
        if(jsonResultArray.isEmpty()) {
            ErrorHandler.throwWordNotFoundError();
        }
        return jsonResultArray.get(0).toString();
    }
}
