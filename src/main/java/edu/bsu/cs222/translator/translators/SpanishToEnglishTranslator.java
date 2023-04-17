package edu.bsu.cs222.translator.translators;
import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.ErrorHandler;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
public class SpanishToEnglishTranslator {
    private final String spanishWordToTranslateToEnglish;
    private final String wordTranslatedToEnglish;
    public SpanishToEnglishTranslator(String spanishWordToTranslateToEnglish) throws IOException, InterruptedException {
        this.spanishWordToTranslateToEnglish = spanishWordToTranslateToEnglish;
        this.wordTranslatedToEnglish = findWordTranslatedToEnglish(requestTranslation());
    }
    private String requestTranslation() throws IOException, InterruptedException {
        TranslationConnection.createLanguageList();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-translator2.p.rapidapi.com/translate"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "f263b8ed6amshcf56c5fd7c784c4p128de1jsna14a7e815ea4")
                .header("X-RapidAPI-Host", "text-translator2.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("source_language=es&target_language=en&text="+spanishWordToTranslateToEnglish))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String findWordTranslatedToEnglish(String translationResponse){
        HashMap<String, String> result = JsonPath.parse(translationResponse).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..translatedText");
        if(jsonResultArray.isEmpty()){
            return ErrorHandler.throwWordNotFoundError().getMessage();
        }
        return jsonResultArray.get(0).toString();
    }
    public String getTranslatedWordInEnglish(){
        return wordTranslatedToEnglish;
    }
}
