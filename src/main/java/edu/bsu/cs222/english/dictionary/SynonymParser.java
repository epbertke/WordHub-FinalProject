package edu.bsu.cs222.english.dictionary;
import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.ErrorHandler;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
public class SynonymParser {
    private final InputStream synonymsInputStream;
    public SynonymParser(String wordSearch) throws IOException {
        this.synonymsInputStream = new APIConnection(wordSearch).getSynonymsInputStream();
    }
    public String parseForSynonyms() throws IOException {
        JSONArray result = JsonPath.parse(synonymsInputStream).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..syns");
        synonymsInputStream.close();
        if (jsonResultArray.isEmpty()) {
            ErrorHandler.throwWordNotFoundError();
        }
        return jsonResultArray.get(0).toString();
    }
}