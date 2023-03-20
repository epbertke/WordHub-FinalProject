package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
public class SynonymParser {
    private final InputStream synonymsInputStream;
    public SynonymParser(InputStream json) {
        synonymsInputStream = json;
    }
    public String parseForSynonyms() throws IOException {
        JSONArray result = JsonPath.parse(synonymsInputStream).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..syns");
        synonymsInputStream.close();
        if (jsonResultArray.isEmpty()) {
            synonymsInputStream.close();
            WordNotFoundError.throwWordNotFoundError();
        }
        return jsonResultArray.get(0).toString();
    }
}
