package edu.bsu.cs222;
import java.io.IOException;
import java.util.ArrayList;

public class RandomWord {
    private final String randomWord;
    private final String randomWordDefinition;
    private final String randomWordSynonyms;
    public RandomWord() throws IOException {
        this.randomWord = fetchRandomWord();
        this.randomWordDefinition = fetchRandomWordDefinition();
        this.randomWordSynonyms = fetchRandomWordSynonyms();
    }
    public String getRandomWord(){
        return randomWord;
    }
    public String getRandomWordDefinition(){
        return randomWordDefinition;
    }
    public String[] getRandomWordInformation(){
        String[] randomWordInformation = new String[3];
        randomWordInformation[0] = this.randomWord;
        randomWordInformation[1] = this.randomWordDefinition;
        randomWordInformation[2] = this.randomWordSynonyms;
        return randomWordInformation;
    }
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private String fetchRandomWord() throws IOException {
        ArrayList<String> wordsArray = new Dictionary().getWordsInDictionary();
        int randomWordIndex = getRandomNumber(0, wordsArray.size());
        return wordsArray.get(randomWordIndex);
    }
    private String fetchRandomWordDefinition() throws IOException {
        APIConnection randomWordConnection = new APIConnection(this.randomWord);
        DefinitionParser randomWordDefinitionFetcher = new DefinitionParser(randomWordConnection.getDefinitionsInputStream());
        return randomWordDefinitionFetcher.fetchDefinition();
    }
    private String fetchRandomWordSynonyms() throws IOException{
        APIConnection randomWordConnection = new APIConnection(this.randomWord);
        SynonymParser randomWordSynonymFetcher = new SynonymParser(randomWordConnection.getSynonymInputStream());
        return randomWordSynonymFetcher.fetchSynonyms();
    }
}
