package edu.bsu.cs222;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
public class APIConnection {
    private final String definitionQuery;
    private final InputStream definitionsInputStream;

    public APIConnection(String wordSearch) throws IOException {
        this.definitionQuery = encodeDefinitionQuery(wordSearch);
        this.definitionsInputStream = fetchDefinitionInputStream();
    }
    public String getDefinitionQuery() {
        return definitionQuery;
    }
    private String encodeDefinitionQuery(String wordSearch){
        return String.format("https://www.dictionaryapi.com/api/v3/references/collegiate/json/%s?key=df32fa24-ccf9-45de-86df-33495904b479", URLEncoder.encode(wordSearch, Charset.defaultCharset()));
    }

    //need method encodeSynonymsQuery
    // https://www.dictionaryapi.com/api/v3/references/thesaurus/json/%s?key=your-api-key is thesaurus requestURL
    //key for thesaurus URL: 2c139559-35fb-4943-9ab6-5ffbf25d3bf8

    private InputStream fetchDefinitionInputStream() throws IOException{
        try{
            URLConnection connection = new URL(this.definitionQuery).openConnection();
            connection.setRequestProperty("Ellie-Bertke","Learn The Dictionary (elliebertke@gmail.com)");
            return connection.getInputStream();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    //need method getSynonymsInputStream
    //will need getter as well to use in SynonymParser class

    public InputStream getDefinitionsInputStream(){
        return this.definitionsInputStream;
    }
}
