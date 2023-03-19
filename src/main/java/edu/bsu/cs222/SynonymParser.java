package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
public class SynonymParser {
    private String synonyms;
    public SynonymParser(InputStream json) throws IOException {
        this.synonyms = parseForSynonym(json);
    }
    public String fetchSynonyms(){ return synonyms;
    }
    private String parseForSynonym(InputStream jsonResponse) throws IOException {
        JSONArray result = JsonPath.parse(jsonResponse).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..syns");
        String synonyms = jsonResultArray.get(1).toString();
        return synonyms;
    }

}
