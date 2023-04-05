package edu.bsu.cs222;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
                .method("POST", HttpRequest.BodyPublishers.ofString("source_language=de&target_language=en&text="+germanWordToTranslateToEnglish))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
