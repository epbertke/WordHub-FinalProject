package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
public class DefinitionParser {
    private final InputStream definitionsInputStream;
    public DefinitionParser(InputStream json) {
        this.definitionsInputStream = json;
    }
    public String parseForDefinition() throws IOException {
        JSONArray result = JsonPath.parse(definitionsInputStream).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..shortdef");
        definitionsInputStream.close();
        if(jsonResultArray.isEmpty()){
            definitionsInputStream.close();
            WordNotFoundError.throwWordNotFoundError();
        }
        return jsonResultArray.get(0).toString();
    }
}
