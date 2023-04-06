package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class FrenchToEnglishTranslator {
    private final String frenchWordToTranslateToEnglish;
    private final String wordTranslatedToEnglish;
    public FrenchToEnglishTranslator(String frenchWordToTranslateToEnglish) throws IOException, InterruptedException{
        this.frenchWordToTranslateToEnglish = frenchWordToTranslateToEnglish;
        this.wordTranslatedToEnglish = findWordTranslatedToEnglish(requestTranslation());

    }
    private String requestTranslation() throws IOException, InterruptedException{
        TranslationConnection.createLanguageList();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-translator2.p.rapidapi.com/translate"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("X-RapidAPI-Key", "f263b8ed6amshcf56c5fd7c784c4p128de1jsna14a7e815ea4")
                .header("X-RapidAPI-Host", "text-translator2.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString("source_language=fr&target_language=en&text="+frenchWordToTranslateToEnglish))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    private String findWordTranslatedToEnglish(String translationResponse){
        HashMap<String, String> result = JsonPath.parse(translationResponse).json();
        JSONArray jsonResultArray = JsonPath.read(result, "$..translatedText");
        if(jsonResultArray.isEmpty()){
            return WordNotFoundError.throwWordNotFoundError().getMessage();

        }
        return jsonResultArray.get(0).toString();
    }
  public String getTranslatedWordInEnglish(){return wordTranslatedToEnglish;}

}