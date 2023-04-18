package edu.bsu.cs222.language.translator.translators.portuguese.translators;

import com.jayway.jsonpath.JsonPath;
import edu.bsu.cs222.ErrorHandler;
import edu.bsu.cs222.language.translator.TranslationConnection;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
public class PortugueseToFrenchTranslator {
    private final String germanWordToTranslateToFrench;
    private final String wordTranslatedToFrench;
    public PortugueseToFrenchTranslator(String userWordToTranslate) throws IOException, InterruptedException {
        this.germanWordToTranslateToFrench = userWordToTranslate;
        this.wordTranslatedToFrench = findWordTranslatedToFrench(requestTranslation());
    }
    private String requestTranslation() throws IOException, InterruptedException {
        TranslationConnection.createLanguageList();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-translator2.p.rapidapi.com/translate"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "f263b8ed6amshcf56c5fd7c784c4p128de1jsna14a7e815ea4")
                .header("X-RapidAPI-Host", "text-translator2.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("source_language=de&target_language=fr&text="+germanWordToTranslateToFrench))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public String findWordTranslatedToFrench(String translationResponse){
        try{
            HashMap<String, String> result = JsonPath.parse(translationResponse).json();
            JSONArray jsonResultArray = JsonPath.read(result, "$..translatedText");
            String responseWord = jsonResultArray.get(0).toString();
            if(jsonResultArray.get(0).toString().equals(germanWordToTranslateToFrench)){
                ErrorHandler.throwWordNotFoundError();
            }
            return responseWord.toLowerCase();
        }catch(Error e){
            return e.getMessage();
        }
    }
    public String getTranslatedWordInFrench(){
        return wordTranslatedToFrench;
    }
}
